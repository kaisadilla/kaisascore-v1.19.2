package azaria.kaisascore.event;

import azaria.kaisascore.item.tools.ExcavatorItem;
import azaria.kaisascore.item.tools.HammerItem;
import azaria.kaisascore.item.tools.ToolHarvesting;
import azaria.kaisascore.util.LevelRendererUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;
import java.util.logging.Level;

// Adaptation from Tinkers' Construct's ToolRenderEvents::renderBlockHighlights.
public class AoeToolHighlight {
    static final int MAX_RENDERED_BLOCKS = 64;

    //@SubscribeEvent
    //public static void spiderStuff (EntityJoinLevelEvent evt) {
    //    var entity = evt.getEntity();
    //    if (entity instanceof Spider == false) return;
    //
    //    System.out.println("SPIDER TREATED");
    //    var spider = (Spider)entity;
    //
    //    spider.goalSelector.getAvailableGoals().clear();
    //    spider.goalSelector.addGoal(1, new FloatGoal(spider));
    //    spider.goalSelector.addGoal(3, new LeapAtTargetGoal(spider, 0.4F));
    //    spider.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(spider, 0.8D));
    //    spider.goalSelector.addGoal(6, new LookAtPlayerGoal(spider, Player.class, 8.0F));
    //    spider.goalSelector.addGoal(6, new RandomLookAroundGoal(spider));
    //}

    @SubscribeEvent
    public static void renderBlockHighlights (RenderHighlightEvent.Block evt) {
        var minecraft = Minecraft.getInstance();
        var level = minecraft.level;
        var player = minecraft.player;
        if (level == null || player == null) return;

        var tool = player.getMainHandItem();
        // if the player is not holding a hammer or an excavator, don't do anything.
        if (tool.isEmpty()) return;
        if ((tool.getItem() instanceof HammerItem
            || tool.getItem() instanceof ExcavatorItem) == false
        ) {
            return;
        }
        var diggerTool = Objects.requireNonNull((DiggerItem)tool.getItem());

        // if the player is not targeting a block, return.
        var hitResult = minecraft.hitResult;
        if (hitResult == null || hitResult.getType() != HitResult.Type.BLOCK) {
            return;
        }

        // check if the tool held by the player is the correct one for the block
        // they're targeting.
        var blockHit = evt.getTarget();
        var targetPos = blockHit.getBlockPos();
        var bState = level.getBlockState(targetPos);
        var canBeMined = diggerTool.isCorrectToolForDrops(tool, bState);
        if (canBeMined == false) return;

        // get all blocks that would be broken by this tool.
        var aoeBlocks = ToolHarvesting.getPositionsInBreakRadius(
            level, player, targetPos, 1, 0
        ).iterator();
        if (aoeBlocks.hasNext() == false) return;

        // set up renderer
        var levelRenderer = evt.getLevelRenderer();
        var poseStack = evt.getPoseStack();
        var buffers = minecraft.renderBuffers().bufferSource();
        var vertexBuilder = buffers.getBuffer(RenderType.LINES);
        poseStack.pushPose();

        // start drawing
        var renderInfo = minecraft.gameRenderer.getMainCamera();
        var viewEntity = renderInfo.getEntity();
        var renderPos = renderInfo.getPosition();

        int renderCount = 0;
        do {
            var pos = aoeBlocks.next();

            if (level.getWorldBorder().isWithinBounds(pos)) {
                LevelRendererUtil.renderHitOutline(
                    level,
                    poseStack,
                    vertexBuilder,
                    viewEntity,
                    renderPos.x,
                    renderPos.y,
                    renderPos.z,
                    pos,
                    level.getBlockState(pos)
                );
                renderCount++;
            }
        }
        while (renderCount < MAX_RENDERED_BLOCKS && aoeBlocks.hasNext());

        poseStack.popPose();
        buffers.endBatch();
    }
}

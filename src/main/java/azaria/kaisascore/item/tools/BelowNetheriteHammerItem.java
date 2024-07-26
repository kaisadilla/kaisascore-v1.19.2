package azaria.kaisascore.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;

import java.util.stream.Stream;

public class BelowNetheriteHammerItem extends BelowNetheritePickaxeItem {
    private boolean _isEnchantable = true;

    public BelowNetheriteHammerItem (
        Tier pTier,
        int pAttackDamageModifier,
        float pAttackSpeedModifier,
        Properties pProperties
    ) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canAttackBlock (BlockState state, Level level, BlockPos target, Player player) {
        int radius = player.isShiftKeyDown() ? 0 : 1;
        var targetBState = level.getBlockState(target);
        float targetHardness = targetBState.getDestroySpeed(level, target);

        // Breaks in a radius only when this tool is the correct one to mine its
        // direct target.
        if (player.getMainHandItem().isCorrectToolForDrops(targetBState)) {
            breakInRadius(level, player, target, radius, 0, bState -> {
                boolean isEffective = player.getMainHandItem().isCorrectToolForDrops(bState);
                if (isEffective == false) return false;

                float hardness = bState.getDestroySpeed(level, target);
                if (hardness > targetHardness) return false;
                if (hardness <= 0) return false;

                return true;
            });
        }

        return true;
    }

    private void breakInRadius (
        Level level,
        Player player,
        BlockPos target,
        int radius,
        int depth,
        ICanBreak canBreak
    ) {
        if (level.isClientSide) return;

        var blocksToBreak = getBreakBlocks(level, player, target, radius, depth);
        var heldItem = player.getMainHandItem();

        blocksToBreak.forEach(pos -> {
            if (pos.equals(target) == true) return;

            var bState = level.getBlockState(pos);
            if (bState.isAir()) return;
            if (canBreak.canBreak(bState) == false) {
                // TODO: this solves the phantom block bug, but why is this necessary?
                ((ServerPlayer)player).connection.send(new ClientboundBlockUpdatePacket(level, pos));
                return;
            };

            var serverPlayer = (ServerPlayer)player;

            if (player.getAbilities().instabuild) {
                if (bState.onDestroyedByPlayer(
                    level, pos, player, true, bState.getFluidState()
                )) {
                    bState.getBlock().destroy(level, pos, bState);
                }
                return;
            }

            var breakEvt = new BlockEvent.BreakEvent(level, pos, bState, player);
            MinecraftForge.EVENT_BUS.post(breakEvt);

            if (breakEvt.isCanceled()) {
                serverPlayer.connection.send(new ClientboundBlockUpdatePacket(level, pos));
                var tile = level.getBlockEntity(pos);
                if (tile == null) return;

                Packet<?> packet = tile.getUpdatePacket();
                if (packet == null) return;

                serverPlayer.connection.send(packet);
                return;
            }

            heldItem.getItem().mineBlock(heldItem, level, bState, pos, player);
            var tile = level.getBlockEntity(pos);
            bState.getBlock().destroy(level, pos, bState);
            bState.getBlock().playerDestroy(level, player, pos, bState, tile, heldItem);
            bState.getBlock().popExperience((ServerLevel)level, pos, breakEvt.getExpToDrop());

            level.removeBlock(pos, false);
            level.levelEvent(2001, pos, Block.getId(bState));
            serverPlayer.connection.send(new ClientboundBlockUpdatePacket(level, pos));
        });
    }

    private Stream<BlockPos> getBreakBlocks (
        Level level, Player player, BlockPos target, int radius, int depth
    ) {
        Stream<BlockPos> blocksToBreak = Stream.of();

        Vec3 eyePos = player.getEyePosition();
        Vec3 rot = player.getViewVector(1);
        var reach = player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue();
        // Creative-mode players have 0.5 extra reach (5 instead of 4.5).
        if (player.isCreative()) {
            reach += 0.5;
        }
        Vec3 combined = eyePos.add(rot.x * reach, rot.y * reach, rot.z * reach);

        var raytraceResult = level.clip(new ClipContext(
            player.getEyePosition(),
            combined,
            ClipContext.Block.OUTLINE,
            ClipContext.Fluid.NONE,
            player
        ));

        if (raytraceResult.getType() != HitResult.Type.BLOCK) {
            return blocksToBreak;
        }

        Direction side = raytraceResult.getDirection();
        boolean xValid = side.getStepX() == 0;
        boolean yValid = side.getStepY() == 0;
        boolean zValid = side.getStepZ() == 0;

        var start = new BlockPos(
            xValid ? -radius : 0,
            yValid ? -radius : 0,
            zValid ? -radius : 0
        );

        var end = new BlockPos(
            xValid ? radius : (depth * -side.getStepX()),
            yValid ? radius : (depth * -side.getStepY()),
            zValid ? radius : (depth * -side.getStepZ())
        );

        return BlockPos.betweenClosedStream(target.offset(start), target.offset(end));
    }
}

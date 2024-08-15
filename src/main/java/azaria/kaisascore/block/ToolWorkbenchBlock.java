package azaria.kaisascore.block;

import azaria.kaisascore.block.entity.ChiselingTableBlockEntity;
import azaria.kaisascore.block.entity.ToolWorkbenchBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class ToolWorkbenchBlock extends BaseEntityBlock {
    protected ToolWorkbenchBlock (Properties props) {
        super(props);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity (BlockPos pos, BlockState state) {
        return new ToolWorkbenchBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape (BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use (
        BlockState state,
        Level level,
        BlockPos pos,
        Player player,
        InteractionHand hand,
        BlockHitResult hit
    ) {
        if (level.isClientSide() == false) {
            var ent = level.getBlockEntity(pos);

            if (ent instanceof ToolWorkbenchBlockEntity toolWorkbenchBE) {
                NetworkHooks.openScreen((ServerPlayer)player, toolWorkbenchBE, pos);
            }
            else {
                throw new IllegalStateException("Container provider missing.");
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void onRemove (
        BlockState state,
        Level level,
        BlockPos pos,
        BlockState newState,
        boolean isMoving
    ) {
        if (state.getBlock() != newState.getBlock()) {
            var ent = level.getBlockEntity(pos);

            if (ent instanceof ToolWorkbenchBlockEntity toolWorkbenchBE) {
                toolWorkbenchBE.dropContents();
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }
}

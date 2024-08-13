package azaria.kaisascore.block;

import azaria.kaisascore.block.entity.ModBlockEntities;
import azaria.kaisascore.block.entity.SmithingTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class SmithingTableBlock extends BaseEntityBlock {

    protected SmithingTableBlock (Properties props) {
        super(props);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity (BlockPos pos, BlockState state) {
        return new SmithingTableBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape (BlockState bstate) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove (BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            var blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof SmithingTableBlockEntity smithingTableBE) {
                smithingTableBE.dropContents();
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
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
            var entity = level.getBlockEntity(pos);

            if (entity instanceof SmithingTableBlockEntity smithingTableBE) {
                NetworkHooks.openScreen((ServerPlayer)player, smithingTableBE, pos);
            }
            else {
                throw new IllegalStateException("Container provider missing.");
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}

package azaria.kaisascore.block;

import azaria.kaisascore.gui.KStonecutterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class KStonecutterBlock extends StonecutterBlock {
    public KStonecutterBlock (Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider (BlockState pState, Level pLevel, BlockPos pPos) {
        return new SimpleMenuProvider((containerId, inventory, player) -> {
            return new KStonecutterMenu(containerId, inventory);
        },Component.translatable("container.stonecutter"));
    }
}

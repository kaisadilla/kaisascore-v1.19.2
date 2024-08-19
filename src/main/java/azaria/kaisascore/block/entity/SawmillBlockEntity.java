package azaria.kaisascore.block.entity;

import azaria.kaisascore.container.inventory.CraftingStationStackHandler;
import azaria.kaisascore.gui.SawmillMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SawmillBlockEntity extends AbstractCraftingStationBlockEntity {
    public SawmillBlockEntity (BlockPos pos, BlockState state) {
        super(ModBlockEntities.SAWMILL.get(), pos, state);

        _inventory = new CraftingStationStackHandler(5 * 5);
    }

    @Override
    public Component getDisplayName () {
        return Component.translatable("container.sawmill");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (
        int containerId, Inventory playerInv, Player player
    ) {
        return new SawmillMenu(containerId, playerInv, this);
    }
}

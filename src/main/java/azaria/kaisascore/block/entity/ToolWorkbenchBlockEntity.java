package azaria.kaisascore.block.entity;

import azaria.kaisascore.gui.ToolWorkbenchMenu;
import azaria.kaisascore.container.inventory.CraftingStationStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ToolWorkbenchBlockEntity extends AbstractCraftingStationBlockEntity {
    public ToolWorkbenchBlockEntity (BlockPos pos, BlockState state) {
        super(ModBlockEntities.TOOL_WORKBENCH.get(), pos, state);

        _inventory = new CraftingStationStackHandler(5 * 5);
    }

    @Override
    public Component getDisplayName () {
        return Component.translatable("container.tool_workbench");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (
        int containerId, Inventory playerInv, Player player
    ) {
        return new ToolWorkbenchMenu(containerId, playerInv, this);
    }
}

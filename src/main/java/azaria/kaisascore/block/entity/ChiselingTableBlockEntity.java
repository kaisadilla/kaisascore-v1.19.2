package azaria.kaisascore.block.entity;

import azaria.kaisascore.container.inventory.CraftingStationStackHandler;
import azaria.kaisascore.gui.ChiselingTableMenu;
import azaria.kaisascore.recipe.ChiselingTableRecipe;
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
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChiselingTableBlockEntity extends BlockEntity implements MenuProvider {
    public static final String NBT_TAG_INVENTORY = "inventory";

    private final CraftingStationStackHandler _inventory;

    public ChiselingTableBlockEntity (BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHISELING_TABLE.get(), pos, state);

        _inventory = new CraftingStationStackHandler(1);
    }

    public CraftingStationStackHandler getInventory () { return _inventory; }

    @Override
    public Component getDisplayName () {
        return Component.translatable("container.chiseling_table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (
        int containerId, Inventory playerInv, Player player
    ) {
        return new ChiselingTableMenu(containerId, playerInv, player);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability (
        @NotNull Capability<T> cap, @Nullable Direction side
    ) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return LazyOptional.empty();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void load (CompoundTag nbt) {
        super.load(nbt);

        _inventory.deserializeNBT(nbt.getCompound(NBT_TAG_INVENTORY));
    }

    @Override
    protected void saveAdditional (CompoundTag nbt) {
        nbt.put(NBT_TAG_INVENTORY, _inventory.serializeNBT());
        super.saveAdditional(nbt);
    }

    public void dropContents () {
        Containers.dropContents(level, worldPosition, _inventory.getStacks());
    }
}

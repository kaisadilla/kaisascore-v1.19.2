package azaria.kaisascore.block.entity;

import azaria.kaisascore.container.inventory.CraftingStationStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractCraftingStationBlockEntity extends BlockEntity implements MenuProvider {
    public static final String NBT_TAG_INVENTORY = "inventory";

    protected CraftingStationStackHandler _inventory;

    public AbstractCraftingStationBlockEntity (
        BlockEntityType<?> type, BlockPos pos, BlockState state
    ) {
        super(type, pos, state);
    }

    public CraftingStationStackHandler getInventory () { return _inventory; }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability (@NotNull Capability<T> cap, @Nullable Direction side) {
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
        // store items inside this container.
        nbt.put(NBT_TAG_INVENTORY, _inventory.serializeNBT());

        super.saveAdditional(nbt);
    }

    public void dropContents () {
        Containers.dropContents(level, worldPosition, _inventory.getStacks());
    }
}

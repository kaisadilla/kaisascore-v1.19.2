package azaria.kaisascore.block.entity;

import azaria.kaisascore.gui.SmithingTableMenu;
import azaria.kaisascore.recipe.SmithingTableRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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

public class SmithingTableBlockEntity extends BlockEntity implements MenuProvider {
    public static final int CONTAINER_SIZE = 3;
    public static final int CONTAINER_DATA_COUNT = 2;

    private final ItemStackHandler _itemHandler = new ItemStackHandler(CONTAINER_SIZE) {
        @Override
        protected void onContentsChanged (int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> _lazyItemHandler = LazyOptional.empty();

    protected final ContainerData _data;
    private int _progress = 0;
    private int _maxProgress = 78;

    public SmithingTableBlockEntity (BlockPos pos, BlockState bstate) {
        super(ModBlockEntities.SMITHING_TABLE.get(), pos, bstate);

        _data = new ContainerData() {
            @Override
            public int get (int index) {
                if (index == 1) return _maxProgress;
                return _progress;
            }

            @Override
            public void set (int index, int value) {
                if (index == 0) {
                    _progress = value;
                }
                else if (index == 1) {
                    _maxProgress = value;
                }
            }

            @Override
            public int getCount () {
                return CONTAINER_DATA_COUNT;
            }
        };
    }

    @Override
    public Component getDisplayName () {
        return Component.literal("Smithing Table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (int containerId, Inventory playerInv, Player player) {
        return new SmithingTableMenu(containerId, playerInv, this, this._data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability (@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return _lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad () {
        super.onLoad();

        _lazyItemHandler = LazyOptional.of(() -> _itemHandler);
    }

    @Override
    public void invalidateCaps () {
        super.invalidateCaps();

        _lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional (CompoundTag nbtTag) {
        // store items inside this container.
        nbtTag.put("inventory", _itemHandler.serializeNBT());
        nbtTag.putInt("smithing_table.progress", _progress);

        super.saveAdditional(nbtTag);
    }

    @Override
    public void load (CompoundTag nbtTag) {
        super.load(nbtTag);

        _itemHandler.deserializeNBT(nbtTag.getCompound("inventory"));
        _progress = nbtTag.getInt("smithing_table.progress");
    }

    public void dropContents () {
        var inventory = getInventory(this);

        Containers.dropContents(level, worldPosition, inventory);
    }

    public static void tick (
        Level level, BlockPos pos, BlockState state, SmithingTableBlockEntity ent
    ) {
        if (level.isClientSide()) return;

        if (hasRecipe(ent)) {
            ent._progress++;
            setChanged(level, pos, state);

            if (ent._progress >= ent._maxProgress) {
                craftItem(ent);
            }
        }
        else {
            ent.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private void resetProgress () {
        _progress = 0;
    }

    private static void craftItem (SmithingTableBlockEntity ent) {
        if (hasRecipe(ent) == false) return;

        var level = ent.level;
        var inventory = getInventory(ent);

        Optional<SmithingTableRecipe> recipe = level
            .getRecipeManager()
            .getRecipeFor(SmithingTableRecipe.Type.INSTANCE, inventory, level);

        ent._itemHandler.extractItem(1, 1, false);
        ent._itemHandler.setStackInSlot(2, new ItemStack(
            recipe.get().getResultItem().getItem(),
            ent._itemHandler.getStackInSlot(2).getCount() + 1
        ));

        ent.resetProgress();
    }

    private static boolean hasRecipe (SmithingTableBlockEntity ent) {
        var level = ent.level;
        var inventory = getInventory(ent);

        Optional<SmithingTableRecipe> recipe = level
            .getRecipeManager()
            .getRecipeFor(SmithingTableRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent()
            && canInsertAmountIntoOutput(inventory)
            && canInsertItemIntoOutput(inventory, recipe.get().getResultItem());

        // todo: guess this is hardcoded for now and will be removed
        //var hasDiamondSwordInFirstSlot = ent._itemHandler.getStackInSlot(1).getItem() == Items.DIAMOND_SWORD;
        //
        //return hasDiamondSwordInFirstSlot
        //    && canInsertAmountIntoOutput(inventory)
        //    && canInsertItemIntoOutput(inventory, new ItemStack(Blocks.OAK_PLANKS.asItem(), 1));
    }

    private static boolean canInsertAmountIntoOutput (SimpleContainer inventory) {
        // you can only insert n items if that wouldn't go beyond the max stack size.
        return inventory.getItem(2).getCount() < inventory.getItem(2).getMaxStackSize();
    }

    private static boolean canInsertItemIntoOutput (SimpleContainer inventory, ItemStack itemStack) {
        // you can only insert the item if the slot is empty or has the same item.
        return inventory.getItem(2).getItem() == itemStack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static SimpleContainer getInventory (SmithingTableBlockEntity ent) {
        var inventory = new SimpleContainer(ent._itemHandler.getSlots());

        for (int i = 0; i < ent._itemHandler.getSlots(); i++) {
            inventory.setItem(i, ent._itemHandler.getStackInSlot(i));
        }

        return inventory;
    }
}

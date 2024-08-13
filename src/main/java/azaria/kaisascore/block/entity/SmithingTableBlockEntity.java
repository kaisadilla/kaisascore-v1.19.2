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
import net.minecraft.world.level.Level;
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

    public static final int TOOL_SLOT = 0;
    public static final int OUTPUT_SLOT = 2;

    private final ItemStackHandler _itemHandler = new ItemStackHandler(CONTAINER_SIZE) {
        @Override
        protected void onContentsChanged (int slot) {
            if (slot != OUTPUT_SLOT) {
                updateRecipe(SmithingTableBlockEntity.this);
            }
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
        return Component.literal("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (int containerId, Inventory playerInv, Player player) {
        System.out.println("MENU CREATED!");
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
    }

    private void resetProgress () {
        _progress = 0;
    }

    private static void __DEL_craftItem (SmithingTableBlockEntity ent) {
        if (__DEL_hasRecipe(ent) == false) return;

        var level = ent.level;
        var inventory = getInventory(ent);

        Optional<SmithingTableRecipe> recipe = level
            .getRecipeManager()
            .getRecipeFor(SmithingTableRecipe.Type.INSTANCE, inventory, level);

        ent._itemHandler.extractItem(1, 2, false);
        ent._itemHandler.setStackInSlot(2, new ItemStack(
            recipe.get().getResultItem().getItem(),
            ent._itemHandler.getStackInSlot(2).getCount() + 1
        ));

        ent.resetProgress();
    }

    /**
     * Returns true if the input items currently placed produce any output.
     * @return
     */
    private static boolean __DEL_hasRecipe (SmithingTableBlockEntity ent) {
        var inventory = getInventory(ent);
        var recipe = getCurrentRecipe(ent);

        return recipe.isPresent()
            && inventory.getItem(1).getCount() >= recipe.get().getIngredients().get(0).getItems()[0].getCount()
            && canInsertAmountIntoOutput(inventory, 1)
            && canInsertItemIntoOutput(inventory, recipe.get().getResultItem());
    }

    private static void updateRecipe (SmithingTableBlockEntity ent) {
        var recipe = getCurrentRecipe(ent);
        var inventory = getInventory(ent);

        if (canOutputRecipe(recipe, inventory)) {
            ent._itemHandler.setStackInSlot(OUTPUT_SLOT, recipe.get().assemble(null));
        }
        else {
            ent._itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);
        }
    }

    private static boolean canOutputRecipe (
        Optional<SmithingTableRecipe> recipe, SimpleContainer inventory
    ) {
        if (recipe.isEmpty()) {
            return false;
        }
        if (hasEnoughIngredients(recipe, inventory) == false) {
            return false;
        }
        if (canInsertItemIntoOutput(inventory, recipe.get().getResultItem()) == false) {
            return false;
        }
        if (canInsertAmountIntoOutput(inventory, recipe.get().getResultItem().getCount()) == false) {
            return false;
        }

        return true;
    }

    private static boolean hasEnoughIngredients (
        Optional<SmithingTableRecipe> recipe, SimpleContainer inventory
    ) {
        return inventory.getItem(TOOL_SLOT).getCount()
            >= recipe.get().getIngredients().get(TOOL_SLOT).getItems()[0].getCount();
    }

    /**
     * Gets the Smithing recipe that corresponds to the items the player has put
     * into this station, if it exists.
     * @param ent The Smithing Table block entity the player is using.
     */
    private static Optional<SmithingTableRecipe> getCurrentRecipe (SmithingTableBlockEntity ent) {
        var inventory = getInventory(ent);
        var recipe = ent.level
            .getRecipeManager()
            .getRecipeFor(SmithingTableRecipe.Type.INSTANCE, inventory, ent.level);

        // No recipe was found, an empty Optional is returned.
        if (recipe.isPresent() == false) return recipe;

        return recipe;
    }

    private static boolean canInsertAmountIntoOutput (SimpleContainer inventory, int amount) {
        // you can only insert n items if that wouldn't go beyond the max stack size.
        return inventory.getItem(OUTPUT_SLOT).getCount() + amount
            <= inventory.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    private static boolean canInsertItemIntoOutput (SimpleContainer inventory, ItemStack itemStack) {
        // you can only insert the item if the slot is empty or has the same item.
        return inventory.getItem(OUTPUT_SLOT).isEmpty()
            || inventory.getItem(OUTPUT_SLOT).getItem() == itemStack.getItem();
    }

    private static SimpleContainer getInventory (SmithingTableBlockEntity ent) {
        var inventory = new SimpleContainer(ent._itemHandler.getSlots());

        for (int i = 0; i < ent._itemHandler.getSlots(); i++) {
            inventory.setItem(i, ent._itemHandler.getStackInSlot(i));
        }

        return inventory;
    }
}

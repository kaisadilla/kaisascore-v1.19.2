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

    public static final int CONTAINER_SIZE = 5;
    public static final int CONTAINER_DATA_COUNT = 4;

    public static final int INGREDIENT_COUNT = 3;
    public static final int BASE_SLOT = 0;
    public static final int FIRST_INGREDIENT_SLOT = 1;
    public static final int OUTPUT_SLOT = 4;

    public static final String NBT_TAG_INVENTORY = "inventory";

    private Optional<SmithingTableRecipe> _recipe = Optional.empty();

    private final ItemStackHandler _itemHandler = new ItemStackHandler(CONTAINER_SIZE) {
        @Override
        protected void onContentsChanged (int slot) {
            if (slot != OUTPUT_SLOT) {
                updateRecipe();
            }
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> _lazyItemHandler = LazyOptional.empty();

    public SmithingTableBlockEntity (BlockPos pos, BlockState bstate) {
        super(ModBlockEntities.SMITHING_TABLE.get(), pos, bstate);
    }

    @Override
    public Component getDisplayName () {
        return Component.literal("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu (int containerId, Inventory playerInv, Player player) {
        return new SmithingTableMenu(containerId, playerInv, this);
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
        nbtTag.put(NBT_TAG_INVENTORY, _itemHandler.serializeNBT());

        super.saveAdditional(nbtTag);
    }

    @Override
    public void load (CompoundTag nbtTag) {
        super.load(nbtTag);

        _itemHandler.deserializeNBT(nbtTag.getCompound(NBT_TAG_INVENTORY));
    }

    public void dropContents () {
        var inventory = getInventory();

        Containers.dropContents(level, worldPosition, inventory);
    }

    /**
     * Removes the ingredients required to craft one item with the current recipe.
     */
    public void craftOne () {
        if (_recipe.isEmpty()) return;

        var baseStack = _itemHandler.getStackInSlot(BASE_SLOT);
        baseStack.setCount(
            Math.max(baseStack.getCount() - _recipe.get().getBase().getCount(), 0)
        );

        // the bounds of the ingredient slots in the inventory.
        int containerStart = SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT;
        int containerEnd = SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT
            + SmithingTableBlockEntity.INGREDIENT_COUNT;

        for (int i = 0; i < _recipe.get().getIngredients().size(); i++) {
            var ing = _recipe.get().getIngredients().get(i).getItems()[0];

            for (int j = containerStart; j < containerEnd; j++) {
                var containerItem = _itemHandler.getStackInSlot(j);

                if (ing.getItem() != containerItem.getItem()) continue;

                containerItem.setCount(
                    Math.max(containerItem.getCount() - ing.getCount(), 0)
                );
            }
        }

        updateRecipe();
    }

    private void updateRecipe () {
        _recipe = getCurrentRecipe();
        var inventory = getInventory();

        if (canOutputRecipe(_recipe, inventory)) {
            _itemHandler.setStackInSlot(OUTPUT_SLOT, _recipe.get().assemble(null));
        }
        else {
            _itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);
        }
    }

    /**
     * Returns true if the items currently placed in this station allow
     * for the recipe given to produce its output.
     * @param recipe The recipe, which can be empty.
     * @param inventory This table's inventory.
     * @return
     */
    private boolean canOutputRecipe (
        Optional<SmithingTableRecipe> recipe, SimpleContainer inventory
    ) {
        if (recipe.isEmpty()) {
            return false;
        }
        if (canPutItemIntoOutput(inventory, recipe.get().getResultItem()) == false) {
            return false;
        }
        if (canIncreaseOutputCountBy(inventory, recipe.get().getResultItem().getCount()) == false) {
            return false;
        }

        return true;
    }

    /**
     * Gets the Smithing recipe that corresponds to the items the player has put
     * into this station, if it exists.
     */
    private Optional<SmithingTableRecipe> getCurrentRecipe () {
        var inventory = getInventory();
        var recipe = level.getRecipeManager()
            .getRecipeFor(SmithingTableRecipe.Type.INSTANCE, inventory, level);

        return recipe;
    }

    /**
     * Returns true if the output stack's count can be increased by the amount given.
     * @param inventory This table's inventory.
     * @param amount The amount to add.
     * @return
     */
    private boolean canIncreaseOutputCountBy (SimpleContainer inventory, int amount) {
        // you can only insert n items if that wouldn't go beyond the max stack size.
        return inventory.getItem(OUTPUT_SLOT).getCount() + amount
            <= inventory.getItem(OUTPUT_SLOT).getMaxStackSize();
    }

    /**
     * Returns true if the item given can be put into the output slot.
     * @param inventory This table's inventory.
     * @param itemStack The item to put.
     * @return
     */
    private boolean canPutItemIntoOutput (SimpleContainer inventory, ItemStack itemStack) {
        // you can only insert the item if the slot is empty or has the same item.
        return inventory.getItem(OUTPUT_SLOT).isEmpty()
            || inventory.getItem(OUTPUT_SLOT).getItem() == itemStack.getItem();
    }

    /**
     * Creates an inventory from the items in this table's slots.
     */
    private SimpleContainer getInventory () {
        var inventory = new SimpleContainer(_itemHandler.getSlots());

        for (int i = 0; i < _itemHandler.getSlots(); i++) {
            inventory.setItem(i, _itemHandler.getStackInSlot(i));
        }

        return inventory;
    }
}

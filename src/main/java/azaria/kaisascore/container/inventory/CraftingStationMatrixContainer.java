package azaria.kaisascore.container.inventory;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;

public class CraftingStationMatrixContainer extends CraftingContainer {
    private final AbstractContainerMenu _container;
    private final CraftingStationStackHandler _inventory;

    public CraftingStationMatrixContainer (
        AbstractContainerMenu container,
        CraftingStationStackHandler inventory,
        int dim
    ) {
        this(container, inventory, dim, dim);
    }

    public CraftingStationMatrixContainer (
        AbstractContainerMenu container,
        CraftingStationStackHandler inventory,
        int width,
        int height
    ) {
        super(container, width, height);
        _container = container;
        _inventory = inventory;
    }

    @Override
    public boolean isEmpty () {
        for (int i = 0; i < getContainerSize(); i++) {
            if (_inventory.getStackInSlot(i).isEmpty() == false) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem (int slot) {
        return _inventory.getStackInSlot(slot);
    }

    @Override
    public ItemStack removeItem (int slot, int amount) {
        var stack = _inventory.extractItem(slot, amount, false);

        _container.slotsChanged(this);

        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate (int slot) {
        var stack = _inventory.getStackInSlot(slot);

        _inventory.setStackInSlot(slot, ItemStack.EMPTY);

        return stack;
    }

    @Override
    public void setItem (int slot, ItemStack stack) {
        _inventory.setStackInSlot(slot, stack);
        _container.slotsChanged(this);
    }

    @Override
    public void setChanged () {}

    @Override
    public boolean stillValid (Player pPlayer) {
        return true;
    }

    @Override
    public void clearContent () {
        for (int i = 0; i < getContainerSize(); i++) {
            _inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }
}

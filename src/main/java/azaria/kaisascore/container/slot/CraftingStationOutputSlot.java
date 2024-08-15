package azaria.kaisascore.container.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CraftingStationOutputSlot extends Slot {
    private final AbstractContainerMenu _menu;
    private final Container _inputMatrix;

    /**
     *
     * @param menu The menu containing this output slot.
     * @param inputMatrix The container that has the items inputted for the recipe.
     * @param inv The player's inventory.
     * @param index The index of this slot in the menu.
     * @param xPos The x position of this slot in the menu.
     * @param yPos The y position of this slot in the menu.
     */
    public CraftingStationOutputSlot (
        AbstractContainerMenu menu,
        Container inputMatrix,
        Container inv,
        int index,
        int xPos,
        int yPos
    ) {
        super(inv, index, xPos, yPos);
        _menu = menu;
        _inputMatrix = inputMatrix;
    }

    @Override
    public boolean mayPlace (ItemStack pStack) {
        return false;
    }

    @Override
    public void onTake (Player pPlayer, ItemStack pStack) {
        // TODO: Take object from result
    }
}

package azaria.kaisascore.container.slot;

import azaria.kaisascore.recipe.ModRecipeTypes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class CraftingStationOutputSlot extends Slot {
    /**
     * The menu that includes this slot.
     */
    private final AbstractContainerMenu _menu;
    /**
     * The crafting station's input.
     */
    private final Container _inputMatrix;

    /**
     *
     * @param menu The menu containing this output slot.
     * @param inputMatrix The container that has the items inputted for the recipe.
     * @param inv The player's inventory.
     * @param index The index of the item in the container represented by this slot.
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
    public boolean mayPlace (ItemStack stack) {
        return false;
    }

    @Override
    public void onTake (Player player, ItemStack stack) {
        ForgeHooks.setCraftingPlayer(player);
        // "leftovers" are the leftovers of a single recipe, e.g. an empty bucket
        // for a recipe that uses a Milk Bucket.
        var leftovers = player.level.getRecipeManager().getRemainingItemsFor(
            ModRecipeTypes.TOOL_WORKBENCH.get(), _inputMatrix, player.level
        );
        ForgeHooks.setCraftingPlayer(null);

        for (int i = 0; i < leftovers.size(); i++) {
            var matrixStack = _inputMatrix.getItem(i);
            var leftoverStack = leftovers.get(i);

            // remove one from each (non-empty) stack in the crafting grid.
            if (matrixStack.isEmpty() == false) {
                _inputMatrix.removeItem(i, 1);
                matrixStack = _inputMatrix.getItem(i);
            }

            // if a leftover item is left in this position
            if (leftoverStack.isEmpty() == false) {
                // if the slot is now empty, put the leftover there.
                if (matrixStack.isEmpty()) {
                    _inputMatrix.setItem(i, leftoverStack);
                }
                // if it's not empty, but the leftover can be stacked with what's
                // there, do so.
                else if (ItemStack.isSame(matrixStack, leftoverStack)
                    && ItemStack.tagMatches(matrixStack, leftoverStack)
                ) {
                    leftoverStack.grow(matrixStack.getCount());
                    _inputMatrix.setItem(i, leftoverStack);
                }
                // else try to place it in the player's inventory. If that isn't,
                // possible either, drop the item.
                else if (player.getInventory().add(leftoverStack) == false) {
                    player.drop(leftoverStack, false);
                }
            }
        }
    }
}

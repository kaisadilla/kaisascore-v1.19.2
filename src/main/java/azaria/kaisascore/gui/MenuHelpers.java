package azaria.kaisascore.gui;

import azaria.kaisascore.gui.screen.ToolWorkbenchScreen;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class MenuHelpers {
    /**
     * The size of a standard slot.
     */
    public static final int SLOT_SIZE = 16;
    /**
     * The distance between two slots in a standard item grid.
     */
    public static final int SLOT_GRID_DIST = 18;

    public static final int DEFAULT_INVENTORY_X = 8;
    public static final int DEFAULT_INVENTORY_Y = 84;
    public static final int DEFAULT_HOTBAR_X = 8;
    public static final int DEFAULT_HOTBAR_Y = 142;

    public static final int DEFAULT_INVENTORY_FIRST_INDEX = 9;
    public static final int DEFAULT_HOTBAR_FIRST_INDEX = 0;
    public static final int DEFAULT_FULL_INVENTORY_FIRST_INDEX = 0;

    public static void addFullPlayerInventory (
        IAddSlot addSlot, Inventory inventory, int firstIndex
    ) {
        addFullPlayerInventory(
            addSlot,
            inventory,
            firstIndex,
            DEFAULT_INVENTORY_X,
            DEFAULT_INVENTORY_Y
        );
    }

    public static void addFullPlayerInventory (
        IAddSlot addSlot, Inventory inventory, int firstIndex, int xPos, int yPos
    ) {
        addPlayerHotbar(addSlot, inventory, firstIndex, xPos, yPos + 58);
        addPlayerInventory(addSlot, inventory, firstIndex + 9, xPos, yPos);
    }

    public static void addPlayerInventory (
        IAddSlot addSlot, Inventory inventory, int firstIndex, int xPos, int yPos
    ) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlot.run(new Slot(
                    inventory,
                    firstIndex + (y * 9) + x,
                    xPos + (x * SLOT_GRID_DIST),
                    yPos + (y * SLOT_GRID_DIST)
                ));
            }
        }
    }

    public static void addPlayerHotbar (
        IAddSlot addSlot, Inventory inventory, int firstIndex, int xPos, int yPos
    ) {
        for (int x = 0; x < 9; x++) {
            addSlot.run(new Slot(
                inventory,
                firstIndex + x,
                xPos + (x * SLOT_GRID_DIST),
                yPos
            ));
        }
    }

    /**
     * Adds a matrix of item slots.
     * @param addSlot The function that adds slots.
     * @param container This matrix's container.
     * @param width The width of the matrix.
     * @param height The height of the matrix.
     * @param firstIndex The index of the first item in the container represented
     *                   by this slot.
     * @param xPos The leftmost position of the matrix.
     * @param yPos The topmost position of the matrix.
     */
    public static void addMatrix (
        IAddSlot addSlot,
        Container container,
        int width,
        int height,
        int firstIndex,
        int xPos,
        int yPos
    ) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                addSlot.run(new Slot(
                    container,
                    firstIndex + (y * width) + x,
                    xPos + (x * SLOT_GRID_DIST),
                    yPos + (y * SLOT_GRID_DIST)
                ));
            }
        }
    }
}

package azaria.kaisascore.gui;

import azaria.kaisascore.block.entity.AbstractCraftingStationBlockEntity;
import azaria.kaisascore.block.entity.ToolWorkbenchBlockEntity;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;

public abstract class AbstractCraftingStationMenu<
    T extends AbstractCraftingStationBlockEntity
> extends AbstractContainerMenu {
    // region Constants
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
    public static final int DEFAULT_CONTAINER_FIRST_SLOT_INDEX = 36;
    // endregion

    protected final Level _level;
    protected final T _ent;
    protected final Container _result;

    protected final Block _accessBlock;

    public AbstractCraftingStationMenu (
        @Nullable MenuType<?> menuType,
        int id,
        Inventory inv,
        BlockEntity ent,
        Block accessBlock
    ) {
        super(menuType, id);

        _level = inv.player.level;
        _ent = (T)ent;
        _result = new ResultContainer();

        _accessBlock = accessBlock;
    }

    @Override
    public boolean stillValid (Player player) {
        return stillValid(
            ContainerLevelAccess.create(_level, _ent.getBlockPos()),
            player,
            _accessBlock
        );
    }

    // region Helper methods
    /**
     * Adds the player's inventory and hotbar at its default position.
     * @param inventory The player's inventory.
     * @param firstIndex The index of the first item in the inventory.
     */
    protected void addFullPlayerInventory (
        Inventory inventory, int firstIndex
    ) {
        addFullPlayerInventory(
            inventory,
            firstIndex,
            DEFAULT_INVENTORY_X,
            DEFAULT_INVENTORY_Y
        );
    }

    /**
     * Adds the player's inventory and hotbar to the position given.
     * @param inventory The player's inventory.
     * @param firstIndex The index of the first item in the inventory.
     * @param xPos The x coordinate relative to the GUI.
     * @param yPos The y coordinate relative to the GUI.
     */
    protected void addFullPlayerInventory (
        Inventory inventory, int firstIndex, int xPos, int yPos
    ) {
        addPlayerHotbar(inventory, firstIndex, xPos, yPos + 58);
        addPlayerInventory(inventory, firstIndex + 9, xPos, yPos);
    }

    protected void addPlayerInventory (
        Inventory inventory, int firstIndex, int xPos, int yPos
    ) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlot(new Slot(
                    inventory,
                    firstIndex + (y * 9) + x,
                    xPos + (x * SLOT_GRID_DIST),
                    yPos + (y * SLOT_GRID_DIST)
                ));
            }
        }
    }

    protected void addPlayerHotbar (
        Inventory inventory, int firstIndex, int xPos, int yPos
    ) {
        for (int x = 0; x < 9; x++) {
            addSlot(new Slot(
                inventory,
                firstIndex + x,
                xPos + (x * SLOT_GRID_DIST),
                yPos
            ));
        }
    }

    /**
     * Adds a matrix of item slots.
     * @param container This matrix's container.
     * @param width The width of the matrix.
     * @param height The height of the matrix.
     * @param firstIndex The index of the first item in the container represented
     *                   by this slot.
     * @param xPos The leftmost position of the matrix.
     * @param yPos The topmost position of the matrix.
     */
    protected void addMatrix (
        Container container,
        int width,
        int height,
        int firstIndex,
        int xPos,
        int yPos
    ) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                addSlot(new Slot(
                    container,
                    firstIndex + (y * width) + x,
                    xPos + (x * SLOT_GRID_DIST),
                    yPos + (y * SLOT_GRID_DIST)
                ));
            }
        }
    }
    // endregion
}

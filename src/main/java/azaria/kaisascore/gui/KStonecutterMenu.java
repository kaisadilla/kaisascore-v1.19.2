package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class KStonecutterMenu extends AbstractContainerMenu {
    private final Level _level;
    private final ContainerLevelAccess _access;

    Inventory _playerInventory;

    public KStonecutterMenu (int containerId, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, inventory);
    }

    public KStonecutterMenu (int containerId, Inventory inventory) {
        super(ModMenuTypes.STONECUTTER_MENU.get(), containerId);
        _level = inventory.player.level;
        _access = ContainerLevelAccess.NULL;

        _playerInventory = inventory;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        addOutputGrid();
    }

    @Override
    public ItemStack quickMoveStack (Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid (Player player) {
        return false;
        //return stillValid(_access, player, ModBlocks.STONECUTTER.get());
    }

    private void addOutputGrid () {
        for (int x = 0; x < 10; x++) {
            int xPos = 62 + (x * 18);
            for (int y = 0; y < 6; y++) {
                int yPos = 8 + 7 + (y * 18);
                int index = (y * 10) + x;
                addDataSlot(DataSlot.standalone());
                //addSlot(new OutputSlot(_playerInventory, index % 36, xPos, yPos));
            }
        }
    }

    private void addPlayerInventory (Inventory inventory) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                int index = (y * 9) + x + 9;
                addSlot(new Slot(inventory, index, 8 + (x * 18), 86 + (y * 18)));
            }
        }
    }

    private void addPlayerHotbar (Inventory inventory) {
        for (int x = 0; x < 9; x++) {
            addSlot(new Slot(inventory, x, 8 + (x * 18), 144));
        }
    }

    //private static class ResultSlot extends SlotItemHandler {
    //    public ResultSlot (IItemHandler itemHandler, int index, int xPos, int yPos) {
    //        super(itemHandler, index, xPos, yPos);
    //    }
    //
    //    @Override
    //    public boolean mayPlace (@NotNull ItemStack stack) {
    //        return super.mayPlace(stack);
    //    }
    //}

    private static class OutputSlot extends Slot {
        public OutputSlot (Container container, int index, int x, int y) {
            super(container, index, x, y);
        }

        @Override
        public void onTake (Player pPlayer, ItemStack pStack) {
            super.onTake(pPlayer, pStack);
        }

        @Override
        public boolean mayPlace (ItemStack pStack) {
            return false;
        }

        @Override
        public int getMaxStackSize () {
            return 1;
        }
    }
}

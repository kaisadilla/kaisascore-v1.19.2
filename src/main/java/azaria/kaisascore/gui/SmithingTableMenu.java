package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.entity.SmithingTableBlockEntity;
import azaria.kaisascore.gui.screen.SmithingTableScreen;
import azaria.kaisascore.recipe.SmithingTableRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class SmithingTableMenu extends AbstractContainerMenu {
    private final SmithingTableBlockEntity _ent;
    private final Level _level;
    private final ContainerData _data;

    private Slot _toolSlot;
    private Slot _resultSlot;
    private ResultContainer _resultContainer = new ResultContainer();

    public SmithingTableMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos()),
            new SimpleContainerData(SmithingTableBlockEntity.CONTAINER_DATA_COUNT)
        );
    }

    public SmithingTableMenu (int id, Inventory inv, BlockEntity ent, ContainerData data) {
        super(ModMenuTypes.SMITHING_TABLE_MENU.get(), id);
        checkContainerSize(inv, SmithingTableBlockEntity.CONTAINER_SIZE);
        _ent = (SmithingTableBlockEntity)ent;
        _level = inv.player.level;
        _data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            _toolSlot = addSlot(new SlotItemHandler(
                handler,
                0,
                SmithingTableScreen.TOOL_SLOT_X,
                SmithingTableScreen.TOOL_SLOT_Y
            ));
            addSlot(new SlotItemHandler(handler, 1, 29, 45));
            //addSlot(new SlotItemHandler(handler, 2, 132, 30));

            _resultSlot = addSlot(new SlotItemHandler(
                handler,
                2,
                132,
                30
            ) {
                @Override
                public boolean mayPlace (@NotNull ItemStack stack) {
                    return false;
                }

                @Override
                public void onTake (Player pPlayer, ItemStack pStack) {
                    // TODO
                    super.onTake(pPlayer, pStack);
                }
            });
        });

        addDataSlots(_data);
    }

    // TODO: 28:15
    @Override
    public ItemStack quickMoveStack (Player player, int index) {
        var stack = ItemStack.EMPTY;
        // TODO: Moving logic.
        return stack;
    }

    @Override
    public boolean stillValid (Player player) {
        return stillValid(
            ContainerLevelAccess.create(_level, _ent.getBlockPos()),
            player,
            ModBlocks.SMITHING_TABLE.get()
        );
    }

    public boolean isCrafting () {
        return _data.get(0) > 0;
    }

    public int getScaledProgress () {
        int progress = _data.get(0);
        int maxProgress = _data.get(1);
        int progressArrowHeight = 26;

        if (progress == 0) return 0;
        if (maxProgress == 0) return 0;

        return (progress * progressArrowHeight) / maxProgress;
    }

    public Slot getToolSlot () {
        return _toolSlot;
    }

    private void addPlayerInventory (Inventory inventory) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                int index = (y * 9) + x + 9;
                addSlot(new Slot(inventory, index, 8 + (x * 18), 84 + (y * 18)));
            }
        }
    }

    private void addPlayerHotbar (Inventory inventory) {
        for (int x = 0; x < 9; x++) {
            addSlot(new Slot(inventory, x, 8 + (x * 18), 142));
        }
    }

    private void setupResultSlot (ItemStack stack) {
        _resultSlot.set(stack);
    }

    @Override
    public void slotsChanged (Container pContainer) {
        System.out.println("things changed");
        super.slotsChanged(pContainer);
    }
}

package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.OverridenBlocks;
import azaria.kaisascore.block.entity.SmithingTableBlockEntity;
import azaria.kaisascore.gui.screen.SmithingTableScreen;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

public class SmithingTableMenu extends AbstractContainerMenu {
    // quickMoveStack constants.
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int REGULAR_INV_COUNT = 3 * 9;
    private static final int TOTAL_PLAYER_INV_COUNT = HOTBAR_SLOT_COUNT + REGULAR_INV_COUNT;
    private static final int LAST_SLOT = TOTAL_PLAYER_INV_COUNT
        + SmithingTableBlockEntity.CONTAINER_SIZE;

    private final SmithingTableBlockEntity _ent;
    private final Level _level;

    private Slot _baseSlot;
    private Slot _ingredientSlots[];
    private Slot _resultSlot;
    private ResultContainer _resultContainer = new ResultContainer();

    public SmithingTableMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos())
        );
    }

    public SmithingTableMenu (int id, Inventory inv, BlockEntity ent) {
        super(ModMenuTypes.SMITHING_TABLE_MENU.get(), id);
        checkContainerSize(inv, SmithingTableBlockEntity.CONTAINER_SIZE);
        _ent = (SmithingTableBlockEntity)ent;
        _level = inv.player.level;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            _baseSlot = addSlot(new SlotItemHandler(
                handler,
                SmithingTableBlockEntity.BASE_SLOT,
                SmithingTableScreen.BASE_SLOT_X,
                SmithingTableScreen.BASE_SLOT_Y
            ));

            _ingredientSlots = new Slot[3];
            _ingredientSlots[0] = addSlot(new SlotItemHandler(
                handler,
                SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT,
                SmithingTableScreen.INGREDIENT_SLOT_FIRST_X,
                SmithingTableScreen.INGREDIENT_SLOT_Y
            ));
            _ingredientSlots[1] = addSlot(new SlotItemHandler(
                handler,
                SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT + 1,
                SmithingTableScreen.INGREDIENT_SLOT_FIRST_X + SmithingTableScreen.INGREDIENT_SLOT_SPACING_X,
                SmithingTableScreen.INGREDIENT_SLOT_Y
            ));
            _ingredientSlots[2] = addSlot(new SlotItemHandler(
                handler,
                SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT + 2,
                SmithingTableScreen.INGREDIENT_SLOT_FIRST_X + (SmithingTableScreen.INGREDIENT_SLOT_SPACING_X * 2),
                SmithingTableScreen.INGREDIENT_SLOT_Y
            ));

            _resultSlot = addSlot(new SlotItemHandler(
                handler,
                SmithingTableBlockEntity.OUTPUT_SLOT,
                SmithingTableScreen.RESULT_SLOT_X,
                SmithingTableScreen.RESULT_SLOT_Y
            ) {
                @Override
                public boolean mayPlace (@NotNull ItemStack stack) {
                    return false;
                }

                @Override
                public void onTake (Player player, ItemStack stack) {
                    ((SmithingTableBlockEntity)ent).craftOne();

                    if (player.level.isClientSide()) {

                    }

                    ContainerLevelAccess.create(_level, _ent.getBlockPos()).execute((level, pos) -> {
                        level.playSound(
                            null,
                            pos,
                            SoundEvents.SMITHING_TABLE_USE,
                            SoundSource.BLOCKS,
                            1f,
                            1f
                        );
                    });
                    super.onTake(player, stack);
                }
            });
        });
    }

    @Override
    public ItemStack quickMoveStack (Player player, int index) {
        var originSlot = slots.get(index);
        if (originSlot == null || originSlot.hasItem() == false) return ItemStack.EMPTY;

        var originStack = originSlot.getItem();
        var copyStack = originStack.copy();

        // the bounds of the ingredient slots in the inventory.
        int containerStart = SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT + TOTAL_PLAYER_INV_COUNT;
        int containerEnd = SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT + TOTAL_PLAYER_INV_COUNT
            + SmithingTableBlockEntity.INGREDIENT_COUNT;

        if (index < TOTAL_PLAYER_INV_COUNT) {
            if (moveItemStackTo(originStack, containerStart, containerEnd, false) == false) {
                return ItemStack.EMPTY;
            }
        }
        else if (index < LAST_SLOT) {
            if (moveItemStackTo(originStack, 0, TOTAL_PLAYER_INV_COUNT, false) == false) {
                return ItemStack.EMPTY;
            }
        }
        else {
            System.out.format("Slot index '%d' is out of bounds", index);
        }

        if (originStack.getCount() == 0) {
            originSlot.set(ItemStack.EMPTY);
        }
        else {
            originSlot.setChanged();
        }

        originSlot.onTake(player, originStack);
        return copyStack;
    }

    @Override
    public boolean stillValid (Player player) {
        return stillValid(
            ContainerLevelAccess.create(_level, _ent.getBlockPos()),
            player,
            OverridenBlocks.SMITHING_TABLE.get()
        );
    }

    public Slot getToolSlot () {
        return _baseSlot;
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
}

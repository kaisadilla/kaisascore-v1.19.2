package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.entity.ChiselingTableBlockEntity;
import azaria.kaisascore.container.inventory.CraftingStationContainer;
import azaria.kaisascore.container.slot.CraftingStationOutputSlot;
import azaria.kaisascore.gui.screen.ChiselingTableScreen;
import azaria.kaisascore.recipe.ModRecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ChiselingTableMenu extends AbstractContainerMenu {
    private static final int INPUT_INDEX = MenuHelpers.DEFAULT_CONTAINER_FIRST_SLOT_INDEX;
    private static final int OUTPUT_INDEX = INPUT_INDEX + 1;

    private final Level _level;
    private final ChiselingTableBlockEntity _ent;
    private final Container _result;

    private final Slot _inputSlot;
    private final Slot _resultSlot;

    private NonNullList<ItemStack> _currentOptions;
    private int _selectedOption = -1;
    private ItemStack _currentInputStack = ItemStack.EMPTY;

    public ChiselingTableMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos())
        );
    }

    public ChiselingTableMenu (int id, Inventory inv, BlockEntity ent) {
        super(ModMenuTypes.CHISELING_TABLE_MENU.get(), id);

        _level = inv.player.level;
        _ent = (ChiselingTableBlockEntity) ent;

        _result = new ResultContainer();

        var inputCont = new CraftingStationContainer(this, _ent.getInventory(), 1);

        MenuHelpers.addFullPlayerInventory(
            this::addSlot,
            inv,
            0,
            ChiselingTableScreen.INVENTORY_X,
            ChiselingTableScreen.INVENTORY_Y
        );

        _inputSlot = addSlot(new Slot(
            inputCont,
            0,
            ChiselingTableScreen.INPUT_X,
            ChiselingTableScreen.INPUT_Y
        ));

        _resultSlot = addSlot(new CraftingStationOutputSlot(
            ModRecipeTypes.CHISELING_TABLE.get(),
            this,
            inputCont,
            _result,
            0,
            ChiselingTableScreen.RESULT_X,
            ChiselingTableScreen.RESULT_Y
        ) {
            @Override
            public void onTake (Player player, ItemStack stack) {
                // remove one from each (non-empty) stack in the crafting grid.
                if (inputCont.isEmpty() == false) {
                    inputCont.removeItem(0, 1);
                }

                slotsChanged(inputCont);

                ContainerLevelAccess.create(_level, _ent.getBlockPos()).execute((level, pos) -> {
                    level.playSound(
                        null,
                        pos,
                        SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                        SoundSource.BLOCKS,
                        1f,
                        1f
                    );
                });
            }
        });

        slotsChanged(inputCont);
    }

    public NonNullList<ItemStack> getCurrentOptions () { return _currentOptions; }
    public int getSelectedOption () { return _selectedOption; }

    @Override
    public void slotsChanged (Container input) {
        ItemStack newInputStack = _inputSlot.getItem();

        if (newInputStack.is(_currentInputStack.getItem())) {
            setupResultSlot();
        }
        else {
            _currentInputStack = newInputStack.copy();
            updateRecipe(input);
            selectOption(-1);
        }

    }

    public void updateRecipe (Container input) {
        var inputStack = input.getItem(0);

        if (inputStack.isEmpty()) {
            _currentOptions = null;
            return;
        }

        var recipe = _level.getRecipeManager()
            .getRecipeFor(ModRecipeTypes.CHISELING_TABLE.get(), input, _level);

        if (recipe.isPresent()) {
            _currentOptions = recipe.get().getOptionsExcept(inputStack);
        }
        else {
            _currentOptions = null;
        }
    }

    @Override
    public boolean stillValid (Player player) {
        return stillValid(
            ContainerLevelAccess.create(_level, _ent.getBlockPos()),
            player,
            ModBlocks.CHISELING_TABLE.get()
        );
    }

    @Override
    public ItemStack quickMoveStack (Player player, int index) {
        var originSlot = slots.get(index);
        if (originSlot == null || originSlot.hasItem() == false) {
            return ItemStack.EMPTY;
        }

        var originStack = originSlot.getItem();
        var copyStack = originStack.copy();

        if (index < INPUT_INDEX) {
            if (moveItemStackTo(originStack, INPUT_INDEX, INPUT_INDEX + 1, false) == false) {
                return ItemStack.EMPTY;
            }
        }
        else if (index <= OUTPUT_INDEX) {
            if (moveItemStackTo(originStack, 0, 36, false) == false) {
                return ItemStack.EMPTY;
            }
        }
        else {
            System.out.format("Slot index '%d' is out of bounds.", index);
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
    public boolean clickMenuButton (Player player, int index) {
        selectOption(index);
        return true;
    }

    // disallowing the result slot from double clicking to group items allows
    // the player to quickly pick more items from that slot.
    @Override
    public boolean canTakeItemForPickAll (ItemStack stack, Slot slot) {
        if (slot == _resultSlot) return false;

        return super.canTakeItemForPickAll(stack, slot);
    }

    public void selectOption (int index) {
        _selectedOption = index;
        setupResultSlot();
    }

    protected void setupResultSlot () {
        if (_selectedOption < 0
            || _currentOptions == null
            || _selectedOption >= _currentOptions.size()
        ) {
            _result.setItem(0, ItemStack.EMPTY);
            return;
        }

        var selectedItem = _currentOptions.get(_selectedOption);
        _result.setItem(0, selectedItem.copy());

        broadcastChanges();
    }
}

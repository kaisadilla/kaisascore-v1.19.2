package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.OverridenBlocks;
import azaria.kaisascore.block.entity.ChiselingTableBlockEntity;
import azaria.kaisascore.container.inventory.CraftingStationContainer;
import azaria.kaisascore.container.slot.CraftingStationOutputSlot;
import azaria.kaisascore.gui.screen.ChiselingTableScreen;
import net.minecraft.network.FriendlyByteBuf;
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
    private final Level _level;
    private final ChiselingTableBlockEntity _ent;
    private final Container _result;

    public ChiselingTableMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos())
        );
    }

    public ChiselingTableMenu (int id, Inventory inv, BlockEntity ent) {
        super(, id);

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

        addSlot(new Slot(
            inputCont,
            0,
            ChiselingTableScreen.INPUT_X,
            ChiselingTableScreen.INPUT_Y
        ));

        addSlot(new CraftingStationOutputSlot(
            this,
            inputCont,
            _result,
            0,
            ChiselingTableScreen.RESULT_X,
            ChiselingTableScreen.RESULT_Y
        ));

        slotsChanged(inputCont);
    }

    @Override
    public void slotsChanged (Container container) {
        // TODO.
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
        // TODO
        return ItemStack.EMPTY;
    }
}

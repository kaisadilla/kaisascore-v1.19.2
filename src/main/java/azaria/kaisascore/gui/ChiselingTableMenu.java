package azaria.kaisascore.gui;

import azaria.kaisascore.block.OverridenBlocks;
import azaria.kaisascore.block.entity.ChiselingTableBlockEntity;
import azaria.kaisascore.container.inventory.CraftingStationContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ResultContainer;
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

        var input = new CraftingStationContainer(this, _ent.getInventory(), 1);
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
            OverridenBlocks.CHISELING_TABLE.get()
        );
    }

    @Override
    public ItemStack quickMoveStack (Player player, int index) {
        // TODO
        return ItemStack.EMPTY;
    }
}

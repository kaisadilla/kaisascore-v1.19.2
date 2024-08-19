package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.entity.SawmillBlockEntity;
import azaria.kaisascore.container.inventory.CraftingStationMatrixContainer;
import azaria.kaisascore.container.slot.CraftingStationOutputSlot;
import azaria.kaisascore.gui.screen.SawmillScreen;
import azaria.kaisascore.recipe.ModRecipeTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class SawmillMenu extends AbstractCraftingStationMenu<SawmillBlockEntity> {
    public static final int MATRIX_SIZE = 5;

    public SawmillMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos())
        );
    }

    public SawmillMenu (int id, Inventory inv, BlockEntity ent) {
        super(
            ModMenuTypes.SAWMILL_MENU.get(),
            id,
            inv,
            ent,
            ModBlocks.SAWMILL.get()
        );

        var inputMatrix = new CraftingStationMatrixContainer(
            this, _ent.getInventory(), MATRIX_SIZE
        );

        addFullPlayerInventory(
            inv,
            0,
            SawmillScreen.INVENTORY_X,
            SawmillScreen.INVENTORY_Y
        );

        addMatrix(
            inputMatrix,
            MATRIX_SIZE,
            MATRIX_SIZE,
            0,
            SawmillScreen.INPUT_MATRIX_X,
            SawmillScreen.INPUT_MATRIX_Y
        );

        addSlot(new CraftingStationOutputSlot(
            ModRecipeTypes.SAWMILL.get(),
            this,
            inputMatrix,
            _result,
            0,
            SawmillScreen.RESULT_SLOT_X,
            SawmillScreen.RESULT_SLOT_Y
        ));

        slotsChanged(inputMatrix);
    }

    @Override
    public void slotsChanged (Container inputMatrix) {
        var recipe = _level.getRecipeManager()
            .getRecipeFor(ModRecipeTypes.SAWMILL.get(), inputMatrix, _level);

        if (recipe.isPresent()) {
            var result = recipe.get().assemble(inputMatrix);
            _result.setItem(0, result);
        }
        else {
            _result.setItem(0, ItemStack.EMPTY);
        }

        super.slotsChanged(inputMatrix);
    }

    @Override
    public ItemStack quickMoveStack (Player pPlayer, int pIndex) {
        return ItemStack.EMPTY; // TODO
    }
}

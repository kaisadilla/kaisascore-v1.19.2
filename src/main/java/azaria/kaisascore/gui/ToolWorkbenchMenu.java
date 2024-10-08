package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.entity.ToolWorkbenchBlockEntity;
import azaria.kaisascore.container.inventory.CraftingStationMatrixContainer;
import azaria.kaisascore.container.slot.CraftingStationOutputSlot;
import azaria.kaisascore.gui.screen.ToolWorkbenchScreen;
import azaria.kaisascore.recipe.ModRecipeTypes;
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

public class ToolWorkbenchMenu extends AbstractCraftingStationMenu<ToolWorkbenchBlockEntity> {
    public static final int MATRIX_SIZE = 5;

    public ToolWorkbenchMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos())
        );
    }

    public ToolWorkbenchMenu (int id, Inventory inv, BlockEntity ent) {
        super(
            ModMenuTypes.TOOL_WORKBENCH_MENU.get(),
            id,
            inv,
            ent,
            ModBlocks.TOOL_WORKBENCH.get()
        );

        var inputMatrix = new CraftingStationMatrixContainer(
            this, _ent.getInventory(), MATRIX_SIZE
        );

        addFullPlayerInventory(
            inv,
            0,
            ToolWorkbenchScreen.INVENTORY_X,
            ToolWorkbenchScreen.INVENTORY_Y
        );

        addMatrix(
            inputMatrix,
            MATRIX_SIZE,
            MATRIX_SIZE,
            0,
            ToolWorkbenchScreen.INPUT_MATRIX_X,
            ToolWorkbenchScreen.INPUT_MATRIX_Y
        );

        addSlot(new CraftingStationOutputSlot(
            ModRecipeTypes.TOOL_WORKBENCH.get(),
            this,
            inputMatrix,
            _result,
            0,
            ToolWorkbenchScreen.RESULT_SLOT_X,
            ToolWorkbenchScreen.RESULT_SLOT_Y
        ));

        slotsChanged(inputMatrix);
    }

    @Override
    public void slotsChanged (Container inputMatrix) {
        var recipe = _level.getRecipeManager()
            .getRecipeFor(ModRecipeTypes.TOOL_WORKBENCH.get(), inputMatrix, _level);

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
    public ItemStack quickMoveStack (Player player, int index) {
        System.out.println(_result.getItem(0).getDisplayName());
        // TODO
        return ItemStack.EMPTY;
    }
}

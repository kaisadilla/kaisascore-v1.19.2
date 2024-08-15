package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.entity.ToolWorkbenchBlockEntity;
import azaria.kaisascore.container.inventory.CraftingStationContainer;
import azaria.kaisascore.container.slot.CraftingStationOutputSlot;
import azaria.kaisascore.gui.screen.ToolWorkbenchScreen;
import azaria.kaisascore.recipe.ModRecipeTypes;
import azaria.kaisascore.recipe.ModRecipes;
import azaria.kaisascore.recipe.SmithingTableRecipe;
import azaria.kaisascore.recipe.ToolWorkbenchRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ToolWorkbenchMenu extends AbstractContainerMenu {
    public static final int MATRIX_SIZE = 5;
    private static final int OUTPUT_SLOT = MATRIX_SIZE * MATRIX_SIZE;

    private final Level _level;
    private final ToolWorkbenchBlockEntity _ent;
    private final Container _result;

    public ToolWorkbenchMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos())
        );
    }

    public ToolWorkbenchMenu (int id, Inventory inv, BlockEntity ent) {
        super(ModMenuTypes.TOOL_WORKBENCH_MENU.get(), id);

        _level = inv.player.level;
        _ent = (ToolWorkbenchBlockEntity)ent;

        _result = new ResultContainer();

        var inputMatrix = new CraftingStationContainer(
            this, _ent.getInventory(), MATRIX_SIZE
        );

        addSlot(new CraftingStationOutputSlot(
            this,
            inputMatrix,
            inv,
            OUTPUT_SLOT,
            ToolWorkbenchScreen.RESULT_SLOT_X,
            ToolWorkbenchScreen.RESULT_SLOT_Y
        ));

        MenuHelpers.addMatrix(
            this::addSlot,
            inputMatrix,
            MATRIX_SIZE,
            MATRIX_SIZE,
            0,
            ToolWorkbenchScreen.INPUT_MATRIX_X,
            ToolWorkbenchScreen.INPUT_MATRIX_Y
        );

        MenuHelpers.addFullPlayerInventory(
            this::addSlot,
            inv,
            0,
            ToolWorkbenchScreen.INVENTORY_X,
            ToolWorkbenchScreen.INVENTORY_Y
        );

        slotsChanged(inputMatrix);
    }

    @Override
    public void slotsChanged (Container inputMatrix) {
        // TODO: Match recipe
        var recipe = _level.getRecipeManager()
            .getRecipeFor(ModRecipeTypes.TOOL_WORKBENCH.get(), inputMatrix, _level);

        var recipes = _level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.TOOL_WORKBENCH.get());

        super.slotsChanged(inputMatrix);
    }

    @Override
    public boolean stillValid (Player player) {
        return stillValid(
            ContainerLevelAccess.create(_level, _ent.getBlockPos()),
            player,
            ModBlocks.TOOL_WORKBENCH.get()
        );
    }

    @Override
    public ItemStack quickMoveStack (Player player, int index) {
        // TODO
        return ItemStack.EMPTY;
    }
}
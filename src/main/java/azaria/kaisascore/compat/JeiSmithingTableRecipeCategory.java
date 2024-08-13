package azaria.kaisascore.compat;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.gui.screen.SmithingTableScreen;
import azaria.kaisascore.recipe.SmithingTableRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class JeiSmithingTableRecipeCategory implements IRecipeCategory<SmithingTableRecipe> {
    public final static ResourceLocation ID = new ResourceLocation(
        KaisasCore.MOD_ID, SmithingTableRecipe.RECIPE_NAME
    );
    public final static ResourceLocation TEX_ID = SmithingTableScreen.BG_TEX_ID;

    private final IDrawable _bg;
    private final IDrawable _icon;

    public JeiSmithingTableRecipeCategory (IGuiHelper helper) {
        _bg = helper.createDrawable(TEX_ID, 0, 0, 176, 85);
        _icon = helper.createDrawableIngredient(
            VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SMITHING_TABLE.get())
        );
    }

    @Override
    public RecipeType<SmithingTableRecipe> getRecipeType () {
        return JeiKaisasCorePlugin.SMITHING_TYPE;
    }

    @Override
    public Component getTitle () {
        return Component.literal("Smithing Table");
    }

    @Override
    public IDrawable getBackground () {
        return _bg;
    }

    @Override
    public IDrawable getIcon () {
        return _icon;
    }

    @Override
    public void setRecipe (
        IRecipeLayoutBuilder builder,
        SmithingTableRecipe recipe,
        IFocusGroup focusGroup
    ) {
        builder
            .addSlot(RecipeIngredientRole.INPUT, 86, 15)
            .addIngredients(recipe.getIngredients().get(0));

        builder
            .addSlot(RecipeIngredientRole.OUTPUT, 86, 60)
            .addItemStack(recipe.getResultItem());
    }
}

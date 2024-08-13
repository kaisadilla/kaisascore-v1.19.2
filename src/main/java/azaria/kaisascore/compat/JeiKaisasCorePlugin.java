package azaria.kaisascore.compat;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.recipe.SmithingTableRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

@JeiPlugin
public class JeiKaisasCorePlugin implements IModPlugin {
    public static RecipeType<SmithingTableRecipe> SMITHING_TYPE = new RecipeType<>(
        JeiSmithingTableRecipeCategory.ID, SmithingTableRecipe.class
    );

    @Override
    public ResourceLocation getPluginUid () {
        return new ResourceLocation(KaisasCore.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories (IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
            new JeiSmithingTableRecipeCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes (IRecipeRegistration registration) {
        var manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        var smithingRecipes = manager.getAllRecipesFor(SmithingTableRecipe.Type.INSTANCE);
        registration.addRecipes(SMITHING_TYPE, smithingRecipes);
    }
}

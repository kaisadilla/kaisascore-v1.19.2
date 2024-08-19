package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class SawmillRecipe extends Abstract5x5Recipe {
    public static final String RECIPE_NAME = "sawmill";
    public static final ResourceLocation ID = new ResourceLocation(
        KaisasCore.MOD_ID, RECIPE_NAME
    );

    public SawmillRecipe (
        ResourceLocation id,
        int width,
        int height,
        NonNullList<Ingredient> ingredients,
        ItemStack result
    ) {
        super(id, width, height, ingredients, result);
    }

    @Override
    public RecipeSerializer<?> getSerializer () {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType () {
        return ModRecipeTypes.SAWMILL.get();
    }

    public static class Serializer extends Abstract5x5RecipeSerializer<SawmillRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public Serializer () {
            super(SawmillRecipe::new);
        }
    }
}

package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.block.entity.SmithingTableBlockEntity;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SmithingTableRecipe implements Recipe<SimpleContainer> {
    public static final String RECIPE_NAME = "smithing";

    private final ResourceLocation _id;
    private final ItemStack _base;
    private final NonNullList<Ingredient> _ingredients;
    private final ItemStack _output;

    public SmithingTableRecipe (
        ResourceLocation id, ItemStack base, NonNullList<Ingredient> ingredients, ItemStack output
    ) {
        _id = id;
        _base = base;
        _ingredients = ingredients;
        _output = output;
    }

    @Override
    public ResourceLocation getId () {
        return _id;
    }

    @Override
    public RecipeSerializer<?> getSerializer () {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType () {
        return Type.INSTANCE;
    }

    public ItemStack getBase () {
        return _base;
    }

    @Override
    public NonNullList<Ingredient> getIngredients () {
        return _ingredients;
    }

    @Override
    public ItemStack getResultItem () {
        return _output;
    }

    @Override
    public ItemStack assemble (SimpleContainer container) {
        return _output.copy();
    }

    @Override
    public boolean matches (SimpleContainer container, Level level) {
        if (level.isClientSide()) return false;

        if (_base.getItem() != container.getItem(SmithingTableBlockEntity.BASE_SLOT).getItem()) {
            return false;
        }

        // the bounds of the ingredient slots in the inventory.
        int containerStart = SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT;
        int containerEnd = SmithingTableBlockEntity.FIRST_INGREDIENT_SLOT
            + SmithingTableBlockEntity.INGREDIENT_COUNT;

        // if there number of ingredient slots occupied is not the same as the
        // number of ingredients in the recipe, then this recipe cannot be a match.
        int occupiedSlots = 0;
        for (int i = containerStart; i < containerEnd; i++) {
            if (container.getItem(i).isEmpty() == false) occupiedSlots++;
        }
        if (occupiedSlots != _ingredients.size()) return false;

        // try to match each recipe ingredient with an ingredient in the inventory.
        for (int i = 0; i < _ingredients.size(); i++) {
            var ing = _ingredients.get(i);
            var invStackFound = false;

            for (int j = containerStart; j < containerEnd; j++) {
                var itemInContainer = container.getItem(j);
                if (ing.test(itemInContainer)) {
                    if (itemInContainer.getCount() >= ing.getItems()[0].getCount()) {
                        invStackFound = true;
                        break;
                    }
                }
            }

            // if no valid stack was found, then this recipe cannot be a match
            if (invStackFound == false) return false;
        }

        return true;
    }

    @Override
    public boolean canCraftInDimensions (int width, int height) {
        return true;
    }

    public static class Type implements RecipeType<SmithingTableRecipe> {
        private Type () {}

        public static final Type INSTANCE = new Type();
        public static final String ID = RECIPE_NAME;
    }

    public static class Serializer implements RecipeSerializer<SmithingTableRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(
            KaisasCore.MOD_ID, RECIPE_NAME
        );


        @Override
        public SmithingTableRecipe fromJson (
            ResourceLocation recipeId, JsonObject jsonRecipe
        ) {
            var base = Ingredient.fromJson(
                GsonHelper.getAsJsonObject(jsonRecipe, "base")
            ).getItems()[0];
            var result = ShapedRecipe.itemStackFromJson(
                GsonHelper.getAsJsonObject(jsonRecipe, "output")
            );

            var jsonIngredients = GsonHelper.getAsJsonArray(jsonRecipe, "ingredients");
            var ingredients = NonNullList.withSize(jsonIngredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromJson(jsonIngredients.get(i)));
            }

            return new SmithingTableRecipe(recipeId, base, ingredients, result);
        }

        @Override
        public @Nullable SmithingTableRecipe fromNetwork (
            ResourceLocation recipeId, FriendlyByteBuf buffer
        ) {
            var base = buffer.readItem();
            int ingredientLength = buffer.readInt();

            var ingredients = NonNullList.withSize(ingredientLength, Ingredient.EMPTY);
            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromNetwork((buffer)));
            }

            var result = buffer.readItem();
            return new SmithingTableRecipe(recipeId, base, ingredients, result);
        }

        @Override
        public void toNetwork (FriendlyByteBuf buffer, SmithingTableRecipe recipe) {
            buffer.writeItemStack(recipe.getBase(), false);

            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }

            buffer.writeItemStack(recipe.getResultItem(), false);
        }
    }
}

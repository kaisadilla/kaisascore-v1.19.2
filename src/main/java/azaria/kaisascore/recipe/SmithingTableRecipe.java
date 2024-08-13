package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import org.jetbrains.annotations.Nullable;

public class SmithingTableRecipe implements Recipe<SimpleContainer> {
    public static final String RECIPE_NAME = "smithing";

    private final ResourceLocation _id;
    private final ItemStack _output;
    private final NonNullList<Ingredient> _recipeItems;

    public SmithingTableRecipe (
        ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems
    ) {
        _id = id;
        _output = output;
        _recipeItems = recipeItems;
    }

    @Override
    public boolean matches (SimpleContainer container, Level level) {
        if (level.isClientSide()) return false;

        return _recipeItems.get(0).test(container.getItem(0));
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
    public boolean canCraftInDimensions (int width, int height) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients () {
        return _recipeItems;
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
            var output = ShapedRecipe.itemStackFromJson(
                GsonHelper.getAsJsonObject(jsonRecipe, "output")
            );

            var ingredients = GsonHelper.getAsJsonArray(jsonRecipe, "ingredients");
            var inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new SmithingTableRecipe(recipeId, output, inputs);
        }

        @Override
        public @Nullable SmithingTableRecipe fromNetwork (
            ResourceLocation recipeId, FriendlyByteBuf buffer
        ) {
            var inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork((buffer)));
            }

            var output = buffer.readItem();
            return new SmithingTableRecipe(recipeId, output, inputs);
        }

        @Override
        public void toNetwork (FriendlyByteBuf buffer, SmithingTableRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }

            buffer.writeItemStack(recipe.getResultItem(), false);
        }
    }
}

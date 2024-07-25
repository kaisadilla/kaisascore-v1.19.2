package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StonecutterRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation _id;
    private final NonNullList<Item> _items;

    public StonecutterRecipe (ResourceLocation id, NonNullList<Item> items) {
        _id = id;
        _items = items;
    }

    @Override
    public boolean matches (SimpleContainer simpleContainer, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble (SimpleContainer simpleContainer) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions (int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem () {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId () {
        return _id;
    }

    @Override
    public RecipeSerializer<?> getSerializer () {
        return null;
    }

    @Override
    public RecipeType<?> getType () {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<StonecutterRecipe> {
        private Type () {}

        public static final Type INSTANCE = new Type();
        public static final String ID = "stonecutter";
    }

    public static class Serializer implements RecipeSerializer<StonecutterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(
            KaisasCore.MOD_ID, "stonecutting"
        );

        @Override
        public StonecutterRecipe fromJson (ResourceLocation recipeId, JsonObject json) {
            JsonArray list = GsonHelper.getAsJsonArray(json, "items");

            NonNullList<Item> items = NonNullList.create();

            for (var entry : list) {
                var itemId = ResourceLocation.tryParse(entry.getAsString());
                if (itemId != null) {
                    items.add(ForgeRegistries.ITEMS.getValue(itemId));
                }
            }

            return new StonecutterRecipe(recipeId, items);
        }

        @Override
        public @Nullable StonecutterRecipe fromNetwork (ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            return null;
        }

        @Override
        public void toNetwork (FriendlyByteBuf friendlyByteBuf, StonecutterRecipe stonecutterRecipe) {

        }

        private static <T> Class<T> castClass(Class<?> cls) {
            return (Class<T>)cls;
        }
    }
}

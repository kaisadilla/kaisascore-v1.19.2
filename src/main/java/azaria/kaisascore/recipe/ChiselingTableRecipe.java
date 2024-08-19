package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.block.ModBlocks;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.Nullable;

public class ChiselingTableRecipe implements Recipe<Container> {
    public static final String RECIPE_NAME = "chiseling";
    public static final ResourceLocation ID = new ResourceLocation(
        KaisasCore.MOD_ID, RECIPE_NAME
    );

    private final ResourceLocation _id;
    private final NonNullList<ItemStack> _options;

    public ChiselingTableRecipe (
        ResourceLocation id,
        NonNullList<ItemStack> options
    ) {
        _id = id;
        _options = options;
    }

    @Override
    public ResourceLocation getId () {
        return _id;
    }

    @Override
    public ItemStack getToastSymbol () {
        return new ItemStack(ModBlocks.CHISELING_TABLE.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer () {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType () {
        return ModRecipeTypes.CHISELING_TABLE.get();
    }

    public NonNullList<ItemStack> getOptions () {
        return _options;
    }

    public NonNullList<ItemStack> getOptionsExcept (ItemStack input) {
        NonNullList<ItemStack> filteredList = NonNullList.create();

        for (var option : _options) {
            if (option.is(input.getItem()) == false) {
                filteredList.add(option);
            }
        }

        return filteredList;
    }

    @Override
    public boolean canCraftInDimensions (int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem () {
        return _options.size() > 0 ? _options.get(0) : ItemStack.EMPTY;
    }

    @Override
    public boolean matches (Container container, Level level) {
        var stack = container.getItem(0);

        for (var option : _options) {
            if (option.getItem() == stack.getItem()) return true;
        }

        return false;
    }

    @Override
    public ItemStack assemble (Container pContainer) {
        return null; // TODO
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems (Container container) {
        return NonNullList.create();
    }

    public static class Serializer implements RecipeSerializer<ChiselingTableRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(
            KaisasCore.MOD_ID, RECIPE_NAME
        );

        @Override
        public ChiselingTableRecipe fromJson (
            ResourceLocation recipeId, JsonObject jsonRecipe
        ) {
            JsonArray jsonOptions = GsonHelper.getAsJsonArray(jsonRecipe, "options");

            NonNullList<ItemStack> options = NonNullList.create();

            for (var option : jsonOptions) {
                var itemId = option.getAsString();
                var item = CraftingHelper.getItem(itemId, false);

                options.add(new ItemStack(item));
            }

            return new ChiselingTableRecipe(recipeId, options);
        }

        @Override
        public @Nullable ChiselingTableRecipe fromNetwork (
            ResourceLocation recipeId, FriendlyByteBuf buffer
        ) {
            int optionCount = buffer.readInt();

            NonNullList<ItemStack> options = NonNullList.withSize(
                optionCount, ItemStack.EMPTY
            );

            for (int i = 0; i < optionCount; i++) {
                options.set(i, buffer.readItem());
            }

            return new ChiselingTableRecipe(ID, options);
        }

        @Override
        public void toNetwork (
            FriendlyByteBuf buffer, ChiselingTableRecipe recipe
        ) {
            buffer.writeInt(recipe._options.size());

            for (ItemStack option : recipe._options) {
                buffer.writeItem(option);
            }
        }
    }
}

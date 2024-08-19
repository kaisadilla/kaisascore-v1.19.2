package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.container.inventory.CraftingStationMatrixContainer;
import azaria.kaisascore.gui.ToolWorkbenchMenu;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

public class ToolWorkbenchRecipe extends Abstract5x5Recipe {
    public static final String RECIPE_NAME = "tool_workbench";
    public static final ResourceLocation ID = new ResourceLocation(
        KaisasCore.MOD_ID, RECIPE_NAME
    );

    public ToolWorkbenchRecipe (
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
        return ModRecipeTypes.TOOL_WORKBENCH.get();
    }

    public static class Serializer extends Abstract5x5RecipeSerializer<ToolWorkbenchRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        public Serializer () {
            super(ToolWorkbenchRecipe::new);
        }
    }
}

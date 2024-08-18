package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
        ForgeRegistries.RECIPE_TYPES, KaisasCore.MOD_ID
    );

    public static final RegistryObject<RecipeType<ToolWorkbenchRecipe>> TOOL_WORKBENCH = registerType(
        ToolWorkbenchRecipe.RECIPE_NAME,
        () -> RecipeType.simple(new ResourceLocation(
            KaisasCore.MOD_ID, ToolWorkbenchRecipe.RECIPE_NAME
        ))
    );

    public static final RegistryObject<RecipeType<ChiselingTableRecipe>> CHISELING_TABLE = registerType(
        ChiselingTableRecipe.RECIPE_NAME,
        () -> RecipeType.simple(new ResourceLocation(
            KaisasCore.MOD_ID, ChiselingTableRecipe.RECIPE_NAME
        ))
    );

    private static <T extends Recipe<Container>> RegistryObject<RecipeType<T>> registerType (
        String name, Supplier<RecipeType<T>> type
    ) {
        return RECIPE_TYPES.register(name, type);
    }

    public static void register (IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}

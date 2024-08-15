package azaria.kaisascore.recipe;

import azaria.kaisascore.KaisasCore;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(
        ForgeRegistries.RECIPE_SERIALIZERS, KaisasCore.MOD_ID
    );

    public static final RegistryObject<RecipeSerializer<SmithingTableRecipe>> SMITHING_TABLE_SERIALIZER
        = SERIALIZERS.register(
            SmithingTableRecipe.RECIPE_NAME,
            () -> SmithingTableRecipe.Serializer.INSTANCE
        );

    public static final RegistryObject<RecipeSerializer<ToolWorkbenchRecipe>> TOOL_WORKBENCH_RECIPE
        = SERIALIZERS.register(
            ToolWorkbenchRecipe.RECIPE_NAME,
            () -> ToolWorkbenchRecipe.Serializer.INSTANCE
        );

    public static void register (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

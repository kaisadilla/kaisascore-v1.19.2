package azaria.kaisascore.gui;

import azaria.kaisascore.KaisasCore;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(
        ForgeRegistries.MENU_TYPES, KaisasCore.MOD_ID
    );

    public static final RegistryObject<MenuType<KStonecutterMenu>> STONECUTTER_MENU
        = registerMenuType("stonecutter_menu", KStonecutterMenu::new);

    public static final RegistryObject<MenuType<SmithingTableMenu>> SMITHING_TABLE_MENU
        = registerMenuType("smithing_table_menu", SmithingTableMenu::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType (
        String name, IContainerFactory<T> factory
    ) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register (IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

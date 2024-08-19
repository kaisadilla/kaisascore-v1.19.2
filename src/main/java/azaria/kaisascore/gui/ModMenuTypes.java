package azaria.kaisascore.gui;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.gui.screen.ChiselingTableScreen;
import azaria.kaisascore.gui.screen.SawmillScreen;
import azaria.kaisascore.gui.screen.SmithingTableScreen;
import azaria.kaisascore.gui.screen.ToolWorkbenchScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
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

    public static final RegistryObject<MenuType<SmithingTableMenu>> SMITHING_TABLE_MENU
        = registerMenuType("smithing_table_menu", SmithingTableMenu::new);

    public static final RegistryObject<MenuType<ToolWorkbenchMenu>> TOOL_WORKBENCH_MENU
        = registerMenuType("tool_workbench_menu", ToolWorkbenchMenu::new);

    public static final RegistryObject<MenuType<ChiselingTableMenu>> CHISELING_TABLE_MENU
        = registerMenuType("chiseling_table_menu", ChiselingTableMenu::new);

    public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL_MENU
        = registerMenuType("sawmill_menu", SawmillMenu::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType (
        String name, IContainerFactory<T> factory
    ) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register (IEventBus eventBus) {
        MENUS.register(eventBus);
    }

    public static void registerScreens () {
        MenuScreens.register(SMITHING_TABLE_MENU.get(), SmithingTableScreen::new);
        MenuScreens.register(TOOL_WORKBENCH_MENU.get(), ToolWorkbenchScreen::new);
        MenuScreens.register(CHISELING_TABLE_MENU.get(), ChiselingTableScreen::new);
        MenuScreens.register(SAWMILL_MENU.get(), SawmillScreen::new);
    }
}

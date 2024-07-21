package azaria.kaisascore.item;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.fluids.ModFluids;
import azaria.kaisascore.item.axe.BelowNetheriteAxeItem;
import azaria.kaisascore.item.pickaxe.BelowNetheritePickaxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, KaisasCore.MOD_ID
    );

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register(
        "steel_ingot",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register(
        "titanium_ingot",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register(
        "raw_titanium",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    // region Pickaxes
    public static final RegistryObject<BelowNetheritePickaxeItem> FLINT_PICK = ITEMS.register(
        "flint_pick",
        () -> new BelowNetheritePickaxeItem(ModTiers.FLINT, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> COPPER_PICKAXE = ITEMS.register(
        "copper_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.COPPER, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> TIN_PICKAXE = ITEMS.register(
        "tin_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.TIN, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> LEAD_PICKAXE = ITEMS.register(
        "lead_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.LEAD, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> BRONZE_PICKAXE = ITEMS.register(
        "bronze_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.BRONZE, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> IRON_PICKAXE = ITEMS.register(
        "iron_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.IRON, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> NICKEL_PICKAXE = ITEMS.register(
        "nickel_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.NICKEL, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        ).setEnchantable(false)
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> STEEL_PICKAXE = ITEMS.register(
        "steel_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.STEEL, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> CONSTANTAN_PICKAXE = ITEMS.register(
        "constantan_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.CONSTANTAN, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        ).setEnchantable(false)
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> INVAR_PICKAXE = ITEMS.register(
        "invar_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.INVAR, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        ).setEnchantable(false)
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> GOLDEN_PICKAXE = ITEMS.register(
        "golden_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.GOLD, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BelowNetheritePickaxeItem> SILVER_PICKAXE = ITEMS.register(
        "silver_pickaxe",
        () -> new BelowNetheritePickaxeItem(ModTiers.SILVER, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<PickaxeItem> ELECTRUM_PICKAXE = ITEMS.register(
        "electrum_pickaxe",
        () -> new PickaxeItem(ModTiers.ELECTRUM, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<PickaxeItem> DIAMOND_PICKAXE = ITEMS.register(
        "diamond_pickaxe",
        () -> new PickaxeItem(ModTiers.DIAMOND, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<PickaxeItem> TITANIUM_PICKAXE = ITEMS.register(
        "titanium_pickaxe",
        () -> new PickaxeItem(ModTiers.TITANIUM, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<BucketItem> LIQUIFIED_COAL_BUCKET = ITEMS.register(
        "liquified_coal_bucket",
        () -> new BucketItem(
            () -> ModFluids.SOURCE_LIQUIFIED_COAL.get(),
            new Item.Properties()
                .stacksTo(1)
                .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Axes
    public static final RegistryObject<Item> FLINT_AXE = ITEMS.register(
        "flint_axe",
        () -> new BelowNetheriteAxeItem(ModTiers.FLINT, 1, 1f, new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

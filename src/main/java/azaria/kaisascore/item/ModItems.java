package azaria.kaisascore.item;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.fluid.ModFluids;
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

    public static final RegistryObject<Item> PYRITE_INGOT = ITEMS.register(
        "pyrite_ingot",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    public static final RegistryObject<Item> RAW_PYRITE = ITEMS.register(
        "raw_pyrite",
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

    public static final RegistryObject<Item> LONG_STICK = ITEMS.register(
        "long_stick",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );

    // region Sand casts
    public static final RegistryObject<Item> BLANK_SAND_CAST = ITEMS.register(
        "blank_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PICKAXE_HEAD_SAND_CAST = ITEMS.register(
        "pickaxe_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> AXE_HEAD_SAND_CAST = ITEMS.register(
        "axe_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHOVEL_HEAD_SAND_CAST = ITEMS.register(
        "shovel_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HOE_HEAD_SAND_CAST = ITEMS.register(
        "hoe_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HAMMER_HEAD_SAND_CAST = ITEMS.register(
        "hammer_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> EXCAVATOR_HEAD_SAND_CAST = ITEMS.register(
        "excavator_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BOW_GRIP_SAND_CAST = ITEMS.register(
        "bow_grip_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_BLADE_SAND_CAST = ITEMS.register(
        "short_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BLADE_SAND_CAST = ITEMS.register(
        "blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LONG_BLADE_SAND_CAST = ITEMS.register(
        "long_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> VERY_LONG_BLADE_SAND_CAST = ITEMS.register(
        "very_long_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> THIN_BLADE_SAND_CAST = ITEMS.register(
        "thin_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> RAPIER_HILT_SAND_CAST = ITEMS.register(
        "rapier_hilt_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_SINGLE_EDGED_BLADE_SAND_CAST = ITEMS.register(
        "short_single_edged_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SINGLE_EDGED_BLADE_SAND_CAST = ITEMS.register(
        "single_edged_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SAI_PRONGS_SAND_CAST = ITEMS.register(
        "sai_prongs_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> CURVED_BLADE_SAND_CAST = ITEMS.register(
        "curved_blade_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> WARHAMMER_HEAD_SAND_CAST = ITEMS.register(
        "warhammer_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BATTLE_AXE_HEAD_SAND_CAST = ITEMS.register(
        "battle_axe_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SCYTHE_HEAD_SAND_CAST = ITEMS.register(
        "scythe_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HALBERD_HEAD_SAND_CAST = ITEMS.register(
        "halberd_head_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> INGOT_SAND_CAST = ITEMS.register(
        "ingot_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NUGGET_SAND_CAST = ITEMS.register(
        "nugget_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> GEAR_SAND_CAST = ITEMS.register(
        "gear_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Red Sand casts
    public static final RegistryObject<Item> BLANK_RED_SAND_CAST = ITEMS.register(
        "blank_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PICKAXE_HEAD_RED_SAND_CAST = ITEMS.register(
        "pickaxe_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> AXE_HEAD_RED_SAND_CAST = ITEMS.register(
        "axe_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHOVEL_HEAD_RED_SAND_CAST = ITEMS.register(
        "shovel_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HOE_HEAD_RED_SAND_CAST = ITEMS.register(
        "hoe_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HAMMER_HEAD_RED_SAND_CAST = ITEMS.register(
        "hammer_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> EXCAVATOR_HEAD_RED_SAND_CAST = ITEMS.register(
        "excavator_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BOW_GRIP_RED_SAND_CAST = ITEMS.register(
        "bow_grip_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_BLADE_RED_SAND_CAST = ITEMS.register(
        "short_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BLADE_RED_SAND_CAST = ITEMS.register(
        "blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LONG_BLADE_RED_SAND_CAST = ITEMS.register(
        "long_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> VERY_LONG_BLADE_RED_SAND_CAST = ITEMS.register(
        "very_long_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> THIN_BLADE_RED_SAND_CAST = ITEMS.register(
        "thin_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> RAPIER_HILT_RED_SAND_CAST = ITEMS.register(
        "rapier_hilt_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_SINGLE_EDGED_BLADE_RED_SAND_CAST = ITEMS.register(
        "short_single_edged_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SINGLE_EDGED_BLADE_RED_SAND_CAST = ITEMS.register(
        "single_edged_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SAI_PRONGS_RED_SAND_CAST = ITEMS.register(
        "sai_prongs_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> CURVED_BLADE_RED_SAND_CAST = ITEMS.register(
        "curved_blade_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> WARHAMMER_HEAD_RED_SAND_CAST = ITEMS.register(
        "warhammer_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BATTLE_AXE_HEAD_RED_SAND_CAST = ITEMS.register(
        "battle_axe_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SCYTHE_HEAD_RED_SAND_CAST = ITEMS.register(
        "scythe_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HALBERD_HEAD_RED_SAND_CAST = ITEMS.register(
        "halberd_head_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> INGOT_RED_SAND_CAST = ITEMS.register(
        "ingot_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NUGGET_RED_SAND_CAST = ITEMS.register(
        "nugget_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> GEAR_RED_SAND_CAST = ITEMS.register(
        "gear_red_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region White Sand casts
    public static final RegistryObject<Item> BLANK_WHITE_SAND_CAST = ITEMS.register(
        "blank_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PICKAXE_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "pickaxe_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> AXE_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "axe_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHOVEL_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "shovel_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HOE_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "hoe_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HAMMER_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "hammer_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> EXCAVATOR_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "excavator_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BOW_GRIP_WHITE_SAND_CAST = ITEMS.register(
        "bow_grip_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "short_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BLADE_WHITE_SAND_CAST = ITEMS.register(
        "blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LONG_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "long_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> VERY_LONG_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "very_long_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> THIN_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "thin_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> RAPIER_HILT_WHITE_SAND_CAST = ITEMS.register(
        "rapier_hilt_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_SINGLE_EDGED_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "short_single_edged_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SINGLE_EDGED_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "single_edged_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SAI_PRONGS_WHITE_SAND_CAST = ITEMS.register(
        "sai_prongs_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> CURVED_BLADE_WHITE_SAND_CAST = ITEMS.register(
        "curved_blade_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> WARHAMMER_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "warhammer_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BATTLE_AXE_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "battle_axe_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SCYTHE_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "scythe_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HALBERD_HEAD_WHITE_SAND_CAST = ITEMS.register(
        "halberd_head_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> INGOT_WHITE_SAND_CAST = ITEMS.register(
        "ingot_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NUGGET_WHITE_SAND_CAST = ITEMS.register(
        "nugget_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> GEAR_WHITE_SAND_CAST = ITEMS.register(
        "gear_white_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Orange Sand casts
    public static final RegistryObject<Item> BLANK_ORANGE_SAND_CAST = ITEMS.register(
        "blank_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PICKAXE_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "pickaxe_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> AXE_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "axe_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHOVEL_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "shovel_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HOE_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "hoe_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HAMMER_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "hammer_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> EXCAVATOR_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "excavator_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BOW_GRIP_ORANGE_SAND_CAST = ITEMS.register(
        "bow_grip_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "short_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LONG_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "long_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> VERY_LONG_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "very_long_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> THIN_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "thin_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> RAPIER_HILT_ORANGE_SAND_CAST = ITEMS.register(
        "rapier_hilt_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_SINGLE_EDGED_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "short_single_edged_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SINGLE_EDGED_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "single_edged_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SAI_PRONGS_ORANGE_SAND_CAST = ITEMS.register(
        "sai_prongs_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> CURVED_BLADE_ORANGE_SAND_CAST = ITEMS.register(
        "curved_blade_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> WARHAMMER_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "warhammer_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BATTLE_AXE_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "battle_axe_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SCYTHE_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "scythe_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HALBERD_HEAD_ORANGE_SAND_CAST = ITEMS.register(
        "halberd_head_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> INGOT_ORANGE_SAND_CAST = ITEMS.register(
        "ingot_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NUGGET_ORANGE_SAND_CAST = ITEMS.register(
        "nugget_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> GEAR_ORANGE_SAND_CAST = ITEMS.register(
        "gear_orange_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Black Sand casts
    public static final RegistryObject<Item> BLANK_BLACK_SAND_CAST = ITEMS.register(
        "blank_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PICKAXE_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "pickaxe_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> AXE_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "axe_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHOVEL_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "shovel_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HOE_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "hoe_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HAMMER_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "hammer_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> EXCAVATOR_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "excavator_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BOW_GRIP_BLACK_SAND_CAST = ITEMS.register(
        "bow_grip_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "short_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BLADE_BLACK_SAND_CAST = ITEMS.register(
        "blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LONG_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "long_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> VERY_LONG_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "very_long_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> THIN_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "thin_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> RAPIER_HILT_BLACK_SAND_CAST = ITEMS.register(
        "rapier_hilt_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_SINGLE_EDGED_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "short_single_edged_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SINGLE_EDGED_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "single_edged_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SAI_PRONGS_BLACK_SAND_CAST = ITEMS.register(
        "sai_prongs_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> CURVED_BLADE_BLACK_SAND_CAST = ITEMS.register(
        "curved_blade_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> WARHAMMER_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "warhammer_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BATTLE_AXE_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "battle_axe_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SCYTHE_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "scythe_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HALBERD_HEAD_BLACK_SAND_CAST = ITEMS.register(
        "halberd_head_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> INGOT_BLACK_SAND_CAST = ITEMS.register(
        "ingot_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NUGGET_BLACK_SAND_CAST = ITEMS.register(
        "nugget_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> GEAR_BLACK_SAND_CAST = ITEMS.register(
        "gear_black_sand_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Gold casts
    public static final RegistryObject<Item> BLANK_GOLD_CAST = ITEMS.register(
        "blank_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PICKAXE_HEAD_GOLD_CAST = ITEMS.register(
        "pickaxe_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> AXE_HEAD_GOLD_CAST = ITEMS.register(
        "axe_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHOVEL_HEAD_GOLD_CAST = ITEMS.register(
        "shovel_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HOE_HEAD_GOLD_CAST = ITEMS.register(
        "hoe_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HAMMER_HEAD_GOLD_CAST = ITEMS.register(
        "hammer_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> EXCAVATOR_HEAD_GOLD_CAST = ITEMS.register(
        "excavator_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BOW_GRIP_GOLD_CAST = ITEMS.register(
        "bow_grip_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_BLADE_GOLD_CAST = ITEMS.register(
        "short_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BLADE_GOLD_CAST = ITEMS.register(
        "blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LONG_BLADE_GOLD_CAST = ITEMS.register(
        "long_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> VERY_LONG_BLADE_GOLD_CAST = ITEMS.register(
        "very_long_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> THIN_BLADE_GOLD_CAST = ITEMS.register(
        "thin_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> RAPIER_HILT_GOLD_CAST = ITEMS.register(
        "rapier_hilt_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SHORT_SINGLE_EDGED_BLADE_GOLD_CAST = ITEMS.register(
        "short_single_edged_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SINGLE_EDGED_BLADE_GOLD_CAST = ITEMS.register(
        "single_edged_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SAI_PRONGS_GOLD_CAST = ITEMS.register(
        "sai_prongs_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> CURVED_BLADE_GOLD_CAST = ITEMS.register(
        "curved_blade_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> WARHAMMER_HEAD_GOLD_CAST = ITEMS.register(
        "warhammer_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BATTLE_AXE_HEAD_GOLD_CAST = ITEMS.register(
        "battle_axe_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> SCYTHE_HEAD_GOLD_CAST = ITEMS.register(
        "scythe_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> HALBERD_HEAD_GOLD_CAST = ITEMS.register(
        "halberd_head_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> INGOT_GOLD_CAST = ITEMS.register(
        "ingot_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NUGGET_GOLD_CAST = ITEMS.register(
        "nugget_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> GEAR_GOLD_CAST = ITEMS.register(
        "gear_gold_cast",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Copper tool parts
    public static final RegistryObject<Item> COPPER_PICKAXE_HEAD = ITEMS.register(
        "copper_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_AXE_HEAD = ITEMS.register(
        "copper_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_SHOVEL_HEAD = ITEMS.register(
        "copper_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_HOE_HEAD = ITEMS.register(
        "copper_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_HAMMER_HEAD = ITEMS.register(
        "copper_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_EXCAVATOR_HEAD = ITEMS.register(
        "copper_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_BOW_GRIP = ITEMS.register(
        "copper_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_SHORT_BLADE = ITEMS.register(
        "copper_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_BLADE = ITEMS.register(
        "copper_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_LONG_BLADE = ITEMS.register(
        "copper_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_VERY_LONG_BLADE = ITEMS.register(
        "copper_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_THIN_BLADE = ITEMS.register(
        "copper_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_RAPIER_HILT = ITEMS.register(
        "copper_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "copper_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_SINGLE_EDGED_BLADE = ITEMS.register(
        "copper_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_SAI_PRONGS = ITEMS.register(
        "copper_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_CURVED_BLADE = ITEMS.register(
        "copper_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_WARHAMMER_HEAD = ITEMS.register(
        "copper_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_BATTLE_AXE_HEAD = ITEMS.register(
        "copper_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_SCYTHE_HEAD = ITEMS.register(
        "copper_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> COPPER_HALBERD_HEAD = ITEMS.register(
        "copper_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Tin tool parts
    public static final RegistryObject<Item> TIN_PICKAXE_HEAD = ITEMS.register(
        "tin_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_AXE_HEAD = ITEMS.register(
        "tin_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_SHOVEL_HEAD = ITEMS.register(
        "tin_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_HOE_HEAD = ITEMS.register(
        "tin_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_HAMMER_HEAD = ITEMS.register(
        "tin_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_EXCAVATOR_HEAD = ITEMS.register(
        "tin_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_BOW_GRIP = ITEMS.register(
        "tin_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_SHORT_BLADE = ITEMS.register(
        "tin_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_BLADE = ITEMS.register(
        "tin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_LONG_BLADE = ITEMS.register(
        "tin_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_VERY_LONG_BLADE = ITEMS.register(
        "tin_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_THIN_BLADE = ITEMS.register(
        "tin_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_RAPIER_HILT = ITEMS.register(
        "tin_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "tin_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_SINGLE_EDGED_BLADE = ITEMS.register(
        "tin_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_SAI_PRONGS = ITEMS.register(
        "tin_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_CURVED_BLADE = ITEMS.register(
        "tin_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_WARHAMMER_HEAD = ITEMS.register(
        "tin_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_BATTLE_AXE_HEAD = ITEMS.register(
        "tin_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_SCYTHE_HEAD = ITEMS.register(
        "tin_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TIN_HALBERD_HEAD = ITEMS.register(
        "tin_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Lead tool parts
    public static final RegistryObject<Item> LEAD_PICKAXE_HEAD = ITEMS.register(
        "lead_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_AXE_HEAD = ITEMS.register(
        "lead_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_SHOVEL_HEAD = ITEMS.register(
        "lead_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_HOE_HEAD = ITEMS.register(
        "lead_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_HAMMER_HEAD = ITEMS.register(
        "lead_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_EXCAVATOR_HEAD = ITEMS.register(
        "lead_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_BOW_GRIP = ITEMS.register(
        "lead_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_SHORT_BLADE = ITEMS.register(
        "lead_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_BLADE = ITEMS.register(
        "lead_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_LONG_BLADE = ITEMS.register(
        "lead_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_VERY_LONG_BLADE = ITEMS.register(
        "lead_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_THIN_BLADE = ITEMS.register(
        "lead_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_RAPIER_HILT = ITEMS.register(
        "lead_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "lead_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_SINGLE_EDGED_BLADE = ITEMS.register(
        "lead_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_SAI_PRONGS = ITEMS.register(
        "lead_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_CURVED_BLADE = ITEMS.register(
        "lead_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_WARHAMMER_HEAD = ITEMS.register(
        "lead_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_BATTLE_AXE_HEAD = ITEMS.register(
        "lead_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_SCYTHE_HEAD = ITEMS.register(
        "lead_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> LEAD_HALBERD_HEAD = ITEMS.register(
        "lead_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Obsidian tool parts
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE_HEAD = ITEMS.register(
        "obsidian_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_AXE_HEAD = ITEMS.register(
        "obsidian_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL_HEAD = ITEMS.register(
        "obsidian_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_HOE_HEAD = ITEMS.register(
        "obsidian_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_HAMMER_HEAD = ITEMS.register(
        "obsidian_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_EXCAVATOR_HEAD = ITEMS.register(
        "obsidian_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_BOW_GRIP = ITEMS.register(
        "obsidian_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_SHORT_BLADE = ITEMS.register(
        "obsidian_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_BLADE = ITEMS.register(
        "obsidian_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_LONG_BLADE = ITEMS.register(
        "obsidian_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_VERY_LONG_BLADE = ITEMS.register(
        "obsidian_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_THIN_BLADE = ITEMS.register(
        "obsidian_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_RAPIER_HILT = ITEMS.register(
        "obsidian_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "obsidian_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_SINGLE_EDGED_BLADE = ITEMS.register(
        "obsidian_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_SAI_PRONGS = ITEMS.register(
        "obsidian_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_CURVED_BLADE = ITEMS.register(
        "obsidian_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_WARHAMMER_HEAD = ITEMS.register(
        "obsidian_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_BATTLE_AXE_HEAD = ITEMS.register(
        "obsidian_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_SCYTHE_HEAD = ITEMS.register(
        "obsidian_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> OBSIDIAN_HALBERD_HEAD = ITEMS.register(
        "obsidian_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Bronze tool parts
    public static final RegistryObject<Item> BRONZE_PICKAXE_HEAD = ITEMS.register(
        "bronze_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_AXE_HEAD = ITEMS.register(
        "bronze_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_SHOVEL_HEAD = ITEMS.register(
        "bronze_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_HOE_HEAD = ITEMS.register(
        "bronze_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_HAMMER_HEAD = ITEMS.register(
        "bronze_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_EXCAVATOR_HEAD = ITEMS.register(
        "bronze_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_BOW_GRIP = ITEMS.register(
        "bronze_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_SHORT_BLADE = ITEMS.register(
        "bronze_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_BLADE = ITEMS.register(
        "bronze_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_LONG_BLADE = ITEMS.register(
        "bronze_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_VERY_LONG_BLADE = ITEMS.register(
        "bronze_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_THIN_BLADE = ITEMS.register(
        "bronze_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_RAPIER_HILT = ITEMS.register(
        "bronze_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "bronze_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_SINGLE_EDGED_BLADE = ITEMS.register(
        "bronze_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_SAI_PRONGS = ITEMS.register(
        "bronze_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_CURVED_BLADE = ITEMS.register(
        "bronze_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_WARHAMMER_HEAD = ITEMS.register(
        "bronze_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_BATTLE_AXE_HEAD = ITEMS.register(
        "bronze_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_SCYTHE_HEAD = ITEMS.register(
        "bronze_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> BRONZE_HALBERD_HEAD = ITEMS.register(
        "bronze_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Iron tool parts
    public static final RegistryObject<Item> IRON_PICKAXE_HEAD = ITEMS.register(
        "iron_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_AXE_HEAD = ITEMS.register(
        "iron_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_SHOVEL_HEAD = ITEMS.register(
        "iron_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_HOE_HEAD = ITEMS.register(
        "iron_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_HAMMER_HEAD = ITEMS.register(
        "iron_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_EXCAVATOR_HEAD = ITEMS.register(
        "iron_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_BOW_GRIP = ITEMS.register(
        "iron_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_SHORT_BLADE = ITEMS.register(
        "iron_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_BLADE = ITEMS.register(
        "iron_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_LONG_BLADE = ITEMS.register(
        "iron_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_VERY_LONG_BLADE = ITEMS.register(
        "iron_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_THIN_BLADE = ITEMS.register(
        "iron_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_RAPIER_HILT = ITEMS.register(
        "iron_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "iron_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_SINGLE_EDGED_BLADE = ITEMS.register(
        "iron_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_SAI_PRONGS = ITEMS.register(
        "iron_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_CURVED_BLADE = ITEMS.register(
        "iron_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_WARHAMMER_HEAD = ITEMS.register(
        "iron_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_BATTLE_AXE_HEAD = ITEMS.register(
        "iron_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_SCYTHE_HEAD = ITEMS.register(
        "iron_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> IRON_HALBERD_HEAD = ITEMS.register(
        "iron_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Nickel tool parts
    public static final RegistryObject<Item> NICKEL_PICKAXE_HEAD = ITEMS.register(
        "nickel_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_AXE_HEAD = ITEMS.register(
        "nickel_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_SHOVEL_HEAD = ITEMS.register(
        "nickel_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_HOE_HEAD = ITEMS.register(
        "nickel_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_HAMMER_HEAD = ITEMS.register(
        "nickel_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_EXCAVATOR_HEAD = ITEMS.register(
        "nickel_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_BOW_GRIP = ITEMS.register(
        "nickel_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_SHORT_BLADE = ITEMS.register(
        "nickel_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_BLADE = ITEMS.register(
        "nickel_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_LONG_BLADE = ITEMS.register(
        "nickel_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_VERY_LONG_BLADE = ITEMS.register(
        "nickel_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_THIN_BLADE = ITEMS.register(
        "nickel_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_RAPIER_HILT = ITEMS.register(
        "nickel_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "nickel_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_SINGLE_EDGED_BLADE = ITEMS.register(
        "nickel_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_SAI_PRONGS = ITEMS.register(
        "nickel_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_CURVED_BLADE = ITEMS.register(
        "nickel_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_WARHAMMER_HEAD = ITEMS.register(
        "nickel_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_BATTLE_AXE_HEAD = ITEMS.register(
        "nickel_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_SCYTHE_HEAD = ITEMS.register(
        "nickel_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> NICKEL_HALBERD_HEAD = ITEMS.register(
        "nickel_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Steel tool parts
    public static final RegistryObject<Item> STEEL_PICKAXE_HEAD = ITEMS.register(
        "steel_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_AXE_HEAD = ITEMS.register(
        "steel_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_SHOVEL_HEAD = ITEMS.register(
        "steel_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_HOE_HEAD = ITEMS.register(
        "steel_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_HAMMER_HEAD = ITEMS.register(
        "steel_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_EXCAVATOR_HEAD = ITEMS.register(
        "steel_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_BOW_GRIP = ITEMS.register(
        "steel_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_SHORT_BLADE = ITEMS.register(
        "steel_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_BLADE = ITEMS.register(
        "steel_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_LONG_BLADE = ITEMS.register(
        "steel_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_VERY_LONG_BLADE = ITEMS.register(
        "steel_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_THIN_BLADE = ITEMS.register(
        "steel_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_RAPIER_HILT = ITEMS.register(
        "steel_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "steel_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_SINGLE_EDGED_BLADE = ITEMS.register(
        "steel_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_SAI_PRONGS = ITEMS.register(
        "steel_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_CURVED_BLADE = ITEMS.register(
        "steel_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_WARHAMMER_HEAD = ITEMS.register(
        "steel_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_BATTLE_AXE_HEAD = ITEMS.register(
        "steel_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_SCYTHE_HEAD = ITEMS.register(
        "steel_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> STEEL_HALBERD_HEAD = ITEMS.register(
        "steel_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Electrum tool parts
    public static final RegistryObject<Item> ELECTRUM_PICKAXE_HEAD = ITEMS.register(
        "electrum_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_AXE_HEAD = ITEMS.register(
        "electrum_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_SHOVEL_HEAD = ITEMS.register(
        "electrum_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_HOE_HEAD = ITEMS.register(
        "electrum_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_HAMMER_HEAD = ITEMS.register(
        "electrum_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_EXCAVATOR_HEAD = ITEMS.register(
        "electrum_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_BOW_GRIP = ITEMS.register(
        "electrum_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_SHORT_BLADE = ITEMS.register(
        "electrum_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_BLADE = ITEMS.register(
        "electrum_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_LONG_BLADE = ITEMS.register(
        "electrum_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_VERY_LONG_BLADE = ITEMS.register(
        "electrum_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_THIN_BLADE = ITEMS.register(
        "electrum_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_RAPIER_HILT = ITEMS.register(
        "electrum_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "electrum_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_SINGLE_EDGED_BLADE = ITEMS.register(
        "electrum_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_SAI_PRONGS = ITEMS.register(
        "electrum_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_CURVED_BLADE = ITEMS.register(
        "electrum_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_WARHAMMER_HEAD = ITEMS.register(
        "electrum_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_BATTLE_AXE_HEAD = ITEMS.register(
        "electrum_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_SCYTHE_HEAD = ITEMS.register(
        "electrum_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> ELECTRUM_HALBERD_HEAD = ITEMS.register(
        "electrum_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Platinum tool parts
    public static final RegistryObject<Item> PLATINUM_PICKAXE_HEAD = ITEMS.register(
        "platinum_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_AXE_HEAD = ITEMS.register(
        "platinum_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_SHOVEL_HEAD = ITEMS.register(
        "platinum_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_HOE_HEAD = ITEMS.register(
        "platinum_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_HAMMER_HEAD = ITEMS.register(
        "platinum_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_EXCAVATOR_HEAD = ITEMS.register(
        "platinum_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_BOW_GRIP = ITEMS.register(
        "platinum_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_SHORT_BLADE = ITEMS.register(
        "platinum_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_BLADE = ITEMS.register(
        "platinum_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_LONG_BLADE = ITEMS.register(
        "platinum_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_VERY_LONG_BLADE = ITEMS.register(
        "platinum_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_THIN_BLADE = ITEMS.register(
        "platinum_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_RAPIER_HILT = ITEMS.register(
        "platinum_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "platinum_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_SINGLE_EDGED_BLADE = ITEMS.register(
        "platinum_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_SAI_PRONGS = ITEMS.register(
        "platinum_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_CURVED_BLADE = ITEMS.register(
        "platinum_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_WARHAMMER_HEAD = ITEMS.register(
        "platinum_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_BATTLE_AXE_HEAD = ITEMS.register(
        "platinum_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_SCYTHE_HEAD = ITEMS.register(
        "platinum_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> PLATINUM_HALBERD_HEAD = ITEMS.register(
        "platinum_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    // region Titanium tool parts
    public static final RegistryObject<Item> TITANIUM_PICKAXE_HEAD = ITEMS.register(
        "titanium_pickaxe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_AXE_HEAD = ITEMS.register(
        "titanium_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_SHOVEL_HEAD = ITEMS.register(
        "titanium_shovel_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_HOE_HEAD = ITEMS.register(
        "titanium_hoe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_HAMMER_HEAD = ITEMS.register(
        "titanium_hammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_EXCAVATOR_HEAD = ITEMS.register(
        "titanium_excavator_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_BOW_GRIP = ITEMS.register(
        "titanium_bow_grip",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_SHORT_BLADE = ITEMS.register(
        "titanium_short_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_BLADE = ITEMS.register(
        "titanium_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_LONG_BLADE = ITEMS.register(
        "titanium_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_VERY_LONG_BLADE = ITEMS.register(
        "titanium_very_long_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_THIN_BLADE = ITEMS.register(
        "titanium_thin_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_RAPIER_HILT = ITEMS.register(
        "titanium_rapier_hilt",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_SHORT_SINGLE_EDGED_BLADE = ITEMS.register(
        "titanium_short_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_SINGLE_EDGED_BLADE = ITEMS.register(
        "titanium_single_edged_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_SAI_PRONGS = ITEMS.register(
        "titanium_sai_prongs",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_CURVED_BLADE = ITEMS.register(
        "titanium_curved_blade",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_WARHAMMER_HEAD = ITEMS.register(
        "titanium_warhammer_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_BATTLE_AXE_HEAD = ITEMS.register(
        "titanium_battle_axe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_SCYTHE_HEAD = ITEMS.register(
        "titanium_scythe_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    public static final RegistryObject<Item> TITANIUM_HALBERD_HEAD = ITEMS.register(
        "titanium_halberd_head",
        () -> new Item(new Item.Properties()
            .tab(ModCreativeModeTab.KAISACRAFT_TAB)
        )
    );
    // endregion

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

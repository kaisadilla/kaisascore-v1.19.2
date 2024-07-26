package azaria.kaisascore.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {
    public static final ForgeTier FLINT = new ForgeTier(
        0,
        64,
        1.2f,
        1.0f,
        2,
        Tags.Blocks.NEEDS_WOOD_TOOL,
        () -> Ingredient.of(Items.FLINT)
    );

    public static final ForgeTier COPPER = new ForgeTier(
        1,
        128,
        3.3f,
        2.0f,
        5,
        BlockTags.NEEDS_STONE_TOOL,
        () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );

    public static final ForgeTier TIN = new ForgeTier(
        0,
        16,
        0.8f,
        -1.0f,
        10,
        Tags.Blocks.NEEDS_WOOD_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.TIN)
    );

    public static final ForgeTier LEAD = new ForgeTier(
        1,
        256,
        4f,
        2.0f,
        2,
        BlockTags.NEEDS_STONE_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.LEAD)
    );

    public static final ForgeTier OBSIDIAN = new ForgeTier(
        1,
        64,
        24f,
        12.0f,
        22,
        BlockTags.NEEDS_STONE_TOOL,
        () -> Ingredient.of(Items.OBSIDIAN)
    );

    public static final ForgeTier BRONZE = new ForgeTier(
        2,
        256,
        5f,
        3.0f,
        10,
        BlockTags.NEEDS_IRON_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.BRONZE)
    );

    public static final ForgeTier IRON = new ForgeTier(
        2,
        256,
        5f,
        3.0f,
        5,
        BlockTags.NEEDS_IRON_TOOL,
        () -> Ingredient.of(Tags.Items.INGOTS_IRON)
    );

    public static final ForgeTier NICKEL = new ForgeTier(
        2,
        384,
        5f,
        4.0f,
        0,
        BlockTags.NEEDS_IRON_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.NICKEL)
    );

    public static final ForgeTier STEEL = new ForgeTier(
        2,
        512,
        8.0f,
        5.0f,
        10,
        BlockTags.NEEDS_IRON_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.STEEL)
    );

    public static final ForgeTier ELECTRUM = new ForgeTier(
        3,
        1024,
        10.0f,
        6.0f,
        22,
        BlockTags.NEEDS_DIAMOND_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.ELECTRUM)
    );

    public static final ForgeTier PLATINUM = new ForgeTier(
        3,
        1536,
        12.0f,
        7.0f,
        30,
        BlockTags.NEEDS_DIAMOND_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.PLATINUM)
    );

    public static final ForgeTier TITANIUM = new ForgeTier(
        3,
        3072,
        16.0f,
        8.0f,
        10,
        BlockTags.NEEDS_DIAMOND_TOOL,
        () -> Ingredient.of(ModTags.Items.Forge.Ingots.TITANIUM)
    );

    //public static Tier TITANIUM;
    //
    //static {
    //    TITANIUM = TierSortingRegistry.registerTier(
    //        new ForgeTier(
    //            4,
    //            3072,
    //            12,
    //            6,
    //            10,
    //            ModTags.Blocks.NEEDS_TITANIUM_TOOL,
    //            () -> Ingredient.of(ModItems.TITANIUM_INGOT.get())
    //        ),
    //        new ResourceLocation(KaisasCore.MOD_ID, "titanium"),
    //        List.of(Tiers.NETHERITE),
    //        List.of()
    //    );
    //}
}

package azaria.kaisascore.block;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.fluid.ModFluids;
import azaria.kaisascore.item.ModCreativeModeTab;
import azaria.kaisascore.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, KaisasCore.MOD_ID
    );

    public static final RegistryObject<Block> MARBLE
        = registerMarble("marble");
    public static final RegistryObject<Block> POLISHED_MARBLE
        = registerMarble("polished_marble");
    public static final RegistryObject<Block> MARBLE_BRICKS
        = registerMarble("marble_bricks");
    public static final RegistryObject<Block> MARBLE_PILLAR
        = registerMarblePillar("marble_pillar");

    public static final RegistryObject<Block> POLISHED_BASALT
        = registerBasalt("polished_basalt");
    public static final RegistryObject<Block> BASALT_BRICKS
        = registerBasalt("basalt_bricks");

    //public static final RegistryObject<Block> polished_TUFF
    //    = registerTuff("polished_tuff");
    //public static final RegistryObject<Block> TUFF_BRICKS
    //    = registerTuff("tuff_bricks");
    //public static final RegistryObject<Block> TUFF_DIAGONAL_BRICKS
    //    = registerTuff("tuff_diagonal_bricks");

    // region Platinum ore
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock(
        "platinum_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock(
        "deepslate_platinum_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    public static final RegistryObject<Block> RAW_PLATINUM_BLOCK = registerBlock(
        "raw_platinum_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(6f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock(
        "platinum_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(6f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    // endregion

    // region Titanium ore
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock(
        "titanium_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock(
        "deepslate_titanium_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = registerBlock(
        "raw_titanium_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(6f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock(
        "titanium_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(6f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );
    // endregion

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock(
        "steel_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(5f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> SAND_GOLD_ORE = registerBlock(
        "sand_gold_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.SAND)
            .strength(1.5f)
            .sound(SoundType.SAND)
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> PYRITE_ORE = registerBlock(
        "pyrite_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> DEEPSLATE_PYRITE_ORE = registerBlock(
        "deepslate_pyrite_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(4.5f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> NETHER_PYRITE_ORE = registerBlock(
        "nether_pyrite_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(3f)
            .requiresCorrectToolForDrops()
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> SAND_PYRITE_ORE = registerBlock(
        "sand_pyrite_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.SAND)
            .strength(1f)
            .sound(SoundType.SAND)
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> DIRT_REDSTONE_ORE = registerBlock(
        "dirt_redstone_ore",
        () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
            .strength(1f)
            .sound(SoundType.GRAVEL)
        ),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    // region Smeltery fluid blocks
    public static final RegistryObject<LiquidBlock> LIQUIFIED_COAL_BLOCK = BLOCKS.register(
        "liquified_coal_block",
        () -> new LiquidBlock(
            ModFluids.SOURCE_LIQUIFIED_COAL,
            BlockBehaviour.Properties.copy(Blocks.LAVA)
        )
    );
    public static final RegistryObject<LiquidBlock> MOLTEN_TITANIUM_BLOCK = BLOCKS.register(
        "molten_titanium_block",
        () -> new LiquidBlock(
            ModFluids.MOLTEN_TITANIUM_SOURCE,
            BlockBehaviour.Properties.copy(Blocks.LAVA)
        )
    );
    // endregion

    //public static final RegistryObject<KStonecutterBlock> STONECUTTER = registerBlock(
    //    "stonecutter",
    //    () -> new KStonecutterBlock(BlockBehaviour.Properties.copy(Blocks.STONECUTTER)),
    //    ModCreativeModeTab.KAISACRAFT_TAB
    //);

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    protected static <T extends Block> RegistryObject<T> registerBlock (
        String name, Supplier<T> block, CreativeModeTab tab
    ) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj, tab);
        return blockObj;
    }

    protected static <T extends Block> RegistryObject<Item> registerBlockItem (
        String name, RegistryObject<T> block, CreativeModeTab tab
    ) {
        return ModItems.ITEMS.register(
            name,
            () -> new BlockItem(block.get(), new Item.Properties().tab(tab))
        );
    }

    // region Register helpers
    private static RegistryObject<Block> registerBasalt (String internalName) {
        return registerBlock(
            internalName,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BASALT).strength(2.25f)
                .explosionResistance(6)
                .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.KAISACRAFT_TAB
        );
    }

    private static RegistryObject<Block> registerMarble (String internalName) {
        return registerBlock(
            internalName,
            () -> new Block(BlockBehaviour.Properties.of(
                    Material.STONE,
                    MaterialColor.QUARTZ
                ).strength(1.2f)
                .explosionResistance(4)
                .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.KAISACRAFT_TAB
        );
    }

    private static RegistryObject<Block> registerMarblePillar (String internalName) {
        return registerBlock(
            internalName,
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(
                    Material.STONE,
                    MaterialColor.QUARTZ
                ).strength(1.2f)
                .explosionResistance(4)
                .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.KAISACRAFT_TAB
        );
    }

    private static RegistryObject<Block> registerTuff (String internalName) {
        return registerBlock(
            internalName,
            () -> new Block(BlockBehaviour.Properties.of(
                    Material.STONE,
                    MaterialColor.TERRACOTTA_YELLOW
                ).strength(3f)
                .explosionResistance(6)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
            ),
            ModCreativeModeTab.KAISACRAFT_TAB
        );
    }
    // endregion
}

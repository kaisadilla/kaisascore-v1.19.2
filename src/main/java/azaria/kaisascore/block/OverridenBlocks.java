package azaria.kaisascore.block;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.item.ModCreativeModeTab;
import azaria.kaisascore.item.OverridenItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class OverridenBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, KaisasCore.MINECRAFT_ID
    );

    public static final RegistryObject<Block> SMITHING_TABLE = registerBlock(
        "smithing_table",
        () -> new SmithingTableBlock(BlockBehaviour.Properties.copy(Blocks.SMITHING_TABLE)),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static final RegistryObject<Block> CHISELING_TABLE = registerBlock(
        "stonecutter",
        () -> new ChiselingTableBlock(BlockBehaviour.Properties.copy(Blocks.STONECUTTER)),
        ModCreativeModeTab.KAISACRAFT_TAB
    );

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    protected static <T extends Block> RegistryObject<T> registerBlock (
        String name, Supplier<T> block, CreativeModeTab tab
    ) {
        var blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj, tab);
        return blockObj;
    }

    protected static <T extends Block> RegistryObject<Item> registerBlockItem (
        String name, RegistryObject<T> block, CreativeModeTab tab
    ) {
        return OverridenItems.ITEMS.register(
            name,
            () -> new BlockItem(block.get(), new Item.Properties().tab(tab))
        );
    }
}

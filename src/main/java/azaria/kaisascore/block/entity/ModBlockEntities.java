package azaria.kaisascore.block.entity;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.OverridenBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
        ForgeRegistries.BLOCK_ENTITY_TYPES, KaisasCore.MOD_ID
    );

    public static final RegistryObject<BlockEntityType<SmithingTableBlockEntity>> SMITHING_TABLE =
        BLOCK_ENTITIES.register(
            "smithing_table",
            () -> BlockEntityType.Builder.of(
                SmithingTableBlockEntity::new,
                OverridenBlocks.SMITHING_TABLE.get()
            ).build(null)
        );

    public static final RegistryObject<BlockEntityType<ChiselingTableBlockEntity>> CHISELING_TABLE =
        BLOCK_ENTITIES.register(
            "chiseling_table",
            () -> BlockEntityType.Builder.of(
                ChiselingTableBlockEntity::new,
                ModBlocks.CHISELING_TABLE.get()
            ).build(null)
        );

    public static final RegistryObject<BlockEntityType<ToolWorkbenchBlockEntity>> TOOL_WORKBENCH =
        BLOCK_ENTITIES.register(
            "tool_workbench",
            () -> BlockEntityType.Builder.of(
                ToolWorkbenchBlockEntity::new,
                ModBlocks.TOOL_WORKBENCH.get()
            ).build(null)
        );

    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

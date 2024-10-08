package azaria.kaisascore;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.OverridenBlocks;
import azaria.kaisascore.block.entity.ModBlockEntities;
import azaria.kaisascore.event.AoeToolHighlight;
import azaria.kaisascore.fluid.ModFluidTypes;
import azaria.kaisascore.fluid.ModFluids;
import azaria.kaisascore.gui.ModMenuTypes;
import azaria.kaisascore.gui.screen.SmithingTableScreen;
import azaria.kaisascore.item.ModItems;
import azaria.kaisascore.item.OverridenItems;
import azaria.kaisascore.recipe.ModRecipeTypes;
import azaria.kaisascore.recipe.ModRecipes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KaisasCore.MOD_ID)
public class KaisasCore
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "kaisascore";
    public static final String MINECRAFT_ID = "minecraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public KaisasCore ()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        OverridenItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        OverridenBlocks.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModRecipeTypes.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            MinecraftForge.EVENT_BUS.register(AoeToolHighlight.class);
            //MinecraftForge.EVENT_BUS.register(new ChopDownTrees());
        }

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            ItemBlockRenderTypes.setRenderLayer(
                ModFluids.SOURCE_LIQUIFIED_COAL.get(),
                RenderType.translucent()
            );
            ItemBlockRenderTypes.setRenderLayer(
                ModFluids.FLOWING_LIQUIFIED_COAL.get(),
                RenderType.translucent()
            );

            ModMenuTypes.registerScreens();
        }
    }

    @SubscribeEvent
    public void register (RegisterEvent evt) {
        System.out.println("Register event!");
        //evt.register(ForgeRegistries.Keys.BLOCKS, reg -> {
        //    reg.register(
        //        new ResourceLocation("minecraft", "stonecutter"),
        //        new KStonecutterBlock(BlockBehaviour.Properties.copy(Blocks.STONECUTTER))
        //    );
        //});
    }
}

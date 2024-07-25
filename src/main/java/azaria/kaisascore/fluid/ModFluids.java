package azaria.kaisascore.fluid;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(
        ForgeRegistries.FLUIDS, KaisasCore.MOD_ID
    );

    public static final RegistryObject<FlowingFluid> SOURCE_LIQUIFIED_COAL = FLUIDS.register(
        "liquified_coal",
        () -> new ForgeFlowingFluid.Source(ModFluids.LIQUIFIED_COAL_PROPS)
    );

    public static final RegistryObject<FlowingFluid> FLOWING_LIQUIFIED_COAL = FLUIDS.register(
        "liquified_coal_flowing",
        () -> new ForgeFlowingFluid.Flowing(ModFluids.LIQUIFIED_COAL_PROPS)
    );

    public static final ForgeFlowingFluid.Properties LIQUIFIED_COAL_PROPS = new ForgeFlowingFluid.Properties(
        ModFluidTypes.LIQUIFIED_COAL_FLUID_TYPE, SOURCE_LIQUIFIED_COAL, FLOWING_LIQUIFIED_COAL
    )
        .slopeFindDistance(4)
        .levelDecreasePerBlock(1)
        .block(ModBlocks.LIQUIFIED_COAL_BLOCK)
        .bucket(ModItems.LIQUIFIED_COAL_BUCKET);

    public static void register (IEventBus bus) {
        FLUIDS.register(bus);
    }
}

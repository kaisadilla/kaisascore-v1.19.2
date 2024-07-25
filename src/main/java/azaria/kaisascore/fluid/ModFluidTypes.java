package azaria.kaisascore.fluid;

import azaria.kaisascore.KaisasCore;
import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL
        = new ResourceLocation(KaisasCore.MOD_ID, "block/liquified_coal_still");
    public static final ResourceLocation WATER_FLOWING_RL
        = new ResourceLocation(KaisasCore.MOD_ID, "block/liquified_coal_flow");
    public static final ResourceLocation LIQUIFIED_COAL_OVERLAY_RL
        = new ResourceLocation(KaisasCore.MOD_ID, "misc/in_liquified_coal");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(
        ForgeRegistries.Keys.FLUID_TYPES, KaisasCore.MOD_ID
    );

    public static final RegistryObject<FluidType> LIQUIFIED_COAL_FLUID_TYPE = register(
        "liquified_coal",
        FluidType.Properties.create()
            .lightLevel(0)
            .density(5_000)
            .viscosity(10_000)
            .temperature(909)
            .canConvertToSource(false)
            .canDrown(true)
            .canHydrate(false)
            .canSwim(false)
            .sound(SoundAction.get(SoundActions.BUCKET_FILL.name()), SoundEvents.BUCKET_FILL_LAVA)
            .sound(SoundAction.get(SoundActions.BUCKET_EMPTY.name()), SoundEvents.BUCKET_EMPTY_LAVA)
    );

    public static RegistryObject<FluidType> register (String name, FluidType.Properties props) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(
            props,
            WATER_STILL_RL,
            WATER_FLOWING_RL,
            LIQUIFIED_COAL_OVERLAY_RL,
            new Vector3f(0.1f, 0.1f, 0.1f)
        ));
    }

    public static void register (IEventBus bus) {
        FLUID_TYPES.register(bus);
    }
}

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
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(
        ForgeRegistries.Keys.FLUID_TYPES, KaisasCore.MOD_ID
    );

    // region Resource loations
    public static final ResourceLocation LIQUIFIED_COAL_STILL_ID
        = new ResourceLocation(KaisasCore.MOD_ID, "block/liquified_coal_still");
    public static final ResourceLocation LIQUIFIED_COAL_FLOWING_ID
        = new ResourceLocation(KaisasCore.MOD_ID, "block/liquified_coal_flow");
    public static final ResourceLocation LIQUIFIED_COAL_OVERLAY_ID
        = new ResourceLocation(KaisasCore.MOD_ID, "misc/in_liquified_coal");

    public static final ResourceLocation MOLTEN_TITANIUM_STILL_ID
        = new ResourceLocation(KaisasCore.MOD_ID, "block/molten_titanium_still");
    public static final ResourceLocation MOLTEN_TITANIUM_FLOWING_ID
        = new ResourceLocation(KaisasCore.MOD_ID, "block/molten_titanium_flowing");
    public static final ResourceLocation MOLTEN_TITANIUM_OVERLAY_ID
        = new ResourceLocation(KaisasCore.MOD_ID, "misc/in_molten_titanium");
    // endregion

    public static final RegistryObject<FluidType> LIQUIFIED_COAL_FLUID_TYPE = FLUID_TYPES.register(
        "liquified_coal",
        () -> new BaseFluidType(
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
            .sound(SoundAction.get(SoundActions.BUCKET_EMPTY.name()), SoundEvents.BUCKET_EMPTY_LAVA),
            LIQUIFIED_COAL_STILL_ID,
            LIQUIFIED_COAL_FLOWING_ID,
            LIQUIFIED_COAL_OVERLAY_ID,
            new Vector3f(0.1f, 0.1f, 0.1f)
        )
    );

    public static final RegistryObject<FluidType> MOLTEN_TITANIUM_FLUID_TYPE = FLUID_TYPES.register(
        "molten_titanium",
        () -> new BaseFluidType(
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
                .sound(SoundAction.get(SoundActions.BUCKET_EMPTY.name()), SoundEvents.BUCKET_EMPTY_LAVA),
            MOLTEN_TITANIUM_STILL_ID,
            MOLTEN_TITANIUM_FLOWING_ID,
            MOLTEN_TITANIUM_OVERLAY_ID,
            new Vector3f(48f / 255f, 41f / 255f, 58f / 255f)
        )
    );

    public static void register (IEventBus bus) {
        FLUID_TYPES.register(bus);
    }
}

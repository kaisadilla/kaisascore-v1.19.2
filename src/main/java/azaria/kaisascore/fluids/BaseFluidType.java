package azaria.kaisascore.fluids;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BaseFluidType extends FluidType {
    private final ResourceLocation _stillTexture;
    private final ResourceLocation _flowingTexture;
    private final ResourceLocation _overlayTexture;
    private final Vector3f _fogColor;

    public BaseFluidType (
        final Properties properties,
        final ResourceLocation stillTexture,
        final ResourceLocation flowingTexture,
        final ResourceLocation overlayTexture,
        final Vector3f fogColor
    ) {
        super(properties);
        _stillTexture = stillTexture;
        _flowingTexture = flowingTexture;
        _overlayTexture = overlayTexture;
        _fogColor = fogColor;
    }

    public ResourceLocation getStillTexture () { return _stillTexture; }
    public ResourceLocation getFlowingTexture () { return _flowingTexture; }
    public ResourceLocation getOverlayTexture () { return _overlayTexture; }
    public Vector3f getFogColor () { return _fogColor; }

    @Override
    public void initializeClient (Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture () {
                return _stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture () {
                return _flowingTexture;
            }

            @Override
            public ResourceLocation getOverlayTexture () {
                return _overlayTexture;
            }

            @Override
            public @NotNull Vector3f modifyFogColor (
                Camera camera,
                float partialTick,
                ClientLevel level,
                int renderDistance,
                float darkenWorldAmount,
                Vector3f fluidFogColor
            ) {
                return _fogColor;
            }

            @Override
            public void modifyFogRender (
                Camera camera,
                FogRenderer.FogMode mode,
                float renderDistance,
                float partialTick,
                float nearDistance,
                float farDistance,
                FogShape shape
            ) {
                RenderSystem.setShaderFogStart(1f/ 16f);
                RenderSystem.setShaderFogEnd(1f);
            }
        });
    }
}

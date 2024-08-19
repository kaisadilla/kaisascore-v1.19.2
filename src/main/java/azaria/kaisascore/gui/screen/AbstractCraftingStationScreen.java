package azaria.kaisascore.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import javax.annotation.Nullable;

public abstract class AbstractCraftingStationScreen<T extends AbstractContainerMenu>
    extends AbstractContainerScreen<T>
{
    public AbstractCraftingStationScreen (
        @Nullable T menuType, Inventory playerInv, Component title
    ) {
        super(menuType, playerInv, title);
    }

    protected void setupRenderSystem (ResourceLocation backgroundTextureId) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, backgroundTextureId);

        leftPos = (width - imageWidth) / 2;
        topPos = (height - imageHeight) / 2;
    }

    /**
     * Renders the texture given as a regular background. This will prepare the
     * render system with said texture, and adjust leftPos and topPos fields so
     * that they place the menu on the center of the screen.
     * @param poseStack The pose stack to use.
     * @param backgroundTextureId The id of the texture to use as background.
     */
    protected void renderStandardBackground (
        PoseStack poseStack,
        ResourceLocation backgroundTextureId
    ) {
        setupRenderSystem(backgroundTextureId);
        blit(poseStack, leftPos, topPos, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render (
        PoseStack poseStack, int xMouse, int yMouse, float partialTick
    ) {
        renderBackground(poseStack);
        super.render(poseStack, xMouse, yMouse, partialTick);
        renderTooltip(poseStack, xMouse, yMouse);
    }
}

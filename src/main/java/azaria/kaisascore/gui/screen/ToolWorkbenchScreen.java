package azaria.kaisascore.gui.screen;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.gui.SmithingTableMenu;
import azaria.kaisascore.gui.ToolWorkbenchMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ToolWorkbenchScreen extends AbstractContainerScreen<ToolWorkbenchMenu> {
    public static final int INPUT_MATRIX_X = 12;
    public static final int INPUT_MATRIX_Y = 17;
    public static final int RESULT_SLOT_X = 142;
    public static final int RESULT_SLOT_Y = 53;
    public static final int INVENTORY_X = 8;
    public static final int INVENTORY_Y = 120;

    public static final ResourceLocation BG_TEX_ID = new ResourceLocation(
        KaisasCore.MOD_ID, "textures/gui/container/tool_workbench.png"
    );

    public ToolWorkbenchScreen (
        ToolWorkbenchMenu menu, Inventory playerInv, Component title
    ) {
        super(menu, playerInv, title);

        inventoryLabelY += 36;
        imageWidth = 175;
        imageHeight = 201;
    }

    @Override
    protected void renderBg (
        PoseStack poseStack, float partialTick, int xMouse, int yMouse
    ) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, BG_TEX_ID);

        int xTopLeft = (width - imageWidth) / 2;
        int yTopLeft = (height - imageHeight) / 2;

        blit(poseStack, xTopLeft, yTopLeft, 0, 0, imageWidth, imageHeight);
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

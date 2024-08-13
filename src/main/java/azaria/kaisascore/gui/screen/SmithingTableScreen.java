package azaria.kaisascore.gui.screen;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.gui.SmithingTableMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public class SmithingTableScreen extends AbstractContainerScreen<SmithingTableMenu> {
    public static final int TOOL_SLOT_X = 49;
    public static final int TOOL_SLOT_Y = 14;

    public static final ResourceLocation BG_TEX_ID = new ResourceLocation(
        KaisasCore.MOD_ID, "textures/gui/container/smithing_table.png"
    );

    public SmithingTableScreen (SmithingTableMenu menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
    }

    @Override
    protected void init () {
        super.init();
    }

    @Override
    protected void renderBg (PoseStack poseStack, float partialTick, int xMouse, int yMouse) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, BG_TEX_ID);

        int xTopLeft = (width - imageWidth) / 2;
        int yTopLeft = (height - imageHeight) / 2;

        blit(poseStack, xTopLeft, yTopLeft, 0, 0, imageWidth, imageHeight);
        renderToolPlaceholderIcon(poseStack, xTopLeft, yTopLeft);

        renderProgressArrow(poseStack, xTopLeft, yTopLeft);
    }

    @Override
    public void render (PoseStack poseStack, int xMouse, int yMouse, float partialTick) {
        renderBackground(poseStack);
        super.render(poseStack, xMouse, yMouse, partialTick);
        renderTooltip(poseStack, xMouse, yMouse);
    }

    private void renderProgressArrow (PoseStack poseStack, int x, int y) {
        if (menu.isCrafting() == false) return;

        blit(poseStack, x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
    }

    private void renderToolPlaceholderIcon (PoseStack poseStack, int xTopLeft, int yTopLeft) {
        if (menu.getToolSlot().getItem() != ItemStack.EMPTY) return;

        blit(poseStack, xTopLeft + TOOL_SLOT_X, yTopLeft + TOOL_SLOT_Y, 176, 0, 16, 16);
    }
}

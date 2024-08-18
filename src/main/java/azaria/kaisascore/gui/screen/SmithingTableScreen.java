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
    public static final int BASE_SLOT_X = 49;
    public static final int BASE_SLOT_Y = 14;

    public static final int INGREDIENT_SLOT_FIRST_X = 29;
    public static final int INGREDIENT_SLOT_SPACING_X = 21;
    public static final int INGREDIENT_SLOT_Y = 45;

    public static final int RESULT_SLOT_X = 132;
    public static final int RESULT_SLOT_Y = 30;

    public static final ResourceLocation BG_TEX_ID = new ResourceLocation(
        KaisasCore.MOD_ID, "textures/gui/container/smithing_table.png"
    );

    public SmithingTableScreen (SmithingTableMenu menu, Inventory playerInv, Component title) {
        super(menu, playerInv, title);
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
    }

    @Override
    public void render (PoseStack poseStack, int xMouse, int yMouse, float partialTick) {
        renderBackground(poseStack);
        super.render(poseStack, xMouse, yMouse, partialTick);
        renderTooltip(poseStack, xMouse, yMouse);
    }

    private void renderToolPlaceholderIcon (PoseStack poseStack, int xTopLeft, int yTopLeft) {
        if (menu.getToolSlot().getItem() != ItemStack.EMPTY) return;

        blit(poseStack, xTopLeft + BASE_SLOT_X, yTopLeft + BASE_SLOT_Y, 176, 0, 16, 16);
    }
}

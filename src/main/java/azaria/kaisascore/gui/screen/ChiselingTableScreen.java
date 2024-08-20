package azaria.kaisascore.gui.screen;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.gui.ChiselingTableMenu;
import azaria.kaisascore.gui.MenuHelpers;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ChiselingTableScreen extends AbstractContainerScreen<ChiselingTableMenu> {
    public final static int INPUT_X = 15;
    public final static int INPUT_Y = 53;
    public final static int RESULT_X = 216;
    public final static int RESULT_Y = 53;
    public final static int INVENTORY_X = 44;
    public final static int INVENTORY_Y = 120;
    public static final int BUTTON_MATRIX_X = 44;
    public static final int BUTTON_MATRIX_Y = 16;
    public static final int BUTTON_MATRIX_WIDTH = 144;
    public static final int BUTTON_MATRIX_HEIGHT = 90;
    public static final int SCROLLBAR_X = 192;
    public static final int SCROLLBAR_Y = 16;

    private final static int VISIBLE_ROWS = 5;
    private final static int BUTTONS_PER_ROW = 8;
    private final static int VISIBLE_BUTTONS = VISIBLE_ROWS * BUTTONS_PER_ROW;

    private float scrollOffset = 0;
    private int firstRow = 0;

    public static final ResourceLocation BG_TEX_ID = new ResourceLocation(
        KaisasCore.MOD_ID, "textures/gui/container/chiseling_table.png"
    );

    public ChiselingTableScreen (
        ChiselingTableMenu menu, Inventory playerInv, Component title
    ) {
        super(menu, playerInv, title);

        inventoryLabelX += 36;
        inventoryLabelY += 37;
        titleLabelX += 37;
        imageWidth = 247;
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
        renderScrollbar(poseStack);
        renderButtons(poseStack, xMouse, yMouse);
        renderOptions();
    }

    @Override
    protected void renderTooltip (PoseStack poseStack, int xMouse, int yMouse) {
        super.renderTooltip(poseStack, xMouse, yMouse);

        var items = menu.getCurrentOptions();
        if (items == null) return;

        var hoveredIndex = indexAtMousePos(xMouse, yMouse);
        if (hoveredIndex == -1) return;

        var hoveredItem = items.get(hoveredIndex);
        renderTooltip(poseStack, hoveredItem, xMouse, yMouse);
    }

    @Override
    public void render (
        PoseStack poseStack, int xMouse, int yMouse, float partialTick
    ) {
        renderBackground(poseStack);
        super.render(poseStack, xMouse, yMouse, partialTick);
        renderTooltip(poseStack, xMouse, yMouse);
    }

    @Override
    public boolean mouseClicked (double xMouse, double yMouse, int button) {
        if (isMouseInsideButtonMatrix((int)xMouse, (int)yMouse)) {
            int index = indexAtMousePos((int)xMouse, (int)yMouse);
            if (index != -1) {
                if (menu.clickMenuButton(minecraft.player, index)) {
                    minecraft.gameMode.handleInventoryButtonClick(menu.containerId, index);
                    minecraft.getSoundManager().play(
                        SimpleSoundInstance.forUI(
                            SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1
                        )
                    );
                }
            }
        }

        return super.mouseClicked(xMouse, yMouse, button);
    }

    @Override
    public boolean mouseScrolled (double xMouse, double yMouse, double delta) {
        if (isScrollbarActive() == false) return true;

        int offscreenRows = getOffscreenRows();
        if (offscreenRows == 0) return true;

        var advancedRows = (int)-delta; // for each 1.0 delta, advance -1 row.
        firstRow = Mth.clamp(firstRow + advancedRows, 0, offscreenRows);
        scrollOffset = Mth.clamp(
            firstRow / (float)offscreenRows,
            0,
            1
        );

        return true;
    }

    protected void renderScrollbar (PoseStack poseStack) {
        final int texScrollbarX = isScrollbarActive() ? 18 : 30;
        final int scrollbarHeight = 15;
        final int scrollArea = BUTTON_MATRIX_HEIGHT - scrollbarHeight;

        int scrollbarPos = (int)(scrollOffset * scrollArea);

        blit(
            poseStack,
            leftPos + SCROLLBAR_X,
            topPos + SCROLLBAR_Y + scrollbarPos,
            texScrollbarX,
            202,
            12,
            scrollbarHeight
        );
    }

    /**
     * Renders the background for each option button. This takes into account if
     * the button is selected, or hovered.
     * @param poseStack The pose stack to draw to.
     * @param xMouse The x position of the mouse in the screen.
     * @param yMouse The y position of the mouse in the screen.
     */
    protected void renderButtons (PoseStack poseStack, int xMouse, int yMouse) {
        var items = menu.getCurrentOptions();
        if (items == null) return;

        final int firstItem = firstRow * BUTTONS_PER_ROW; // inclusive
        final int lastItem = firstItem + VISIBLE_BUTTONS; // exclusive

        final int btnSize = 18;
        final int hoveredItem = indexAtMousePos(xMouse, yMouse);

        for (int i = firstItem; i < items.size() && i < lastItem; i++) {
            var iRel = i - firstItem;

            // the absolute position of the button in the client's screen.
            int buttonXPos = leftPos + BUTTON_MATRIX_X
                + (btnSize * (iRel % BUTTONS_PER_ROW));
            int buttonYPos = topPos + BUTTON_MATRIX_Y
                + (btnSize * (iRel / BUTTONS_PER_ROW));
            // the button's topleft's y in the texture.
            int texButtonY = 202;

            // if the button is selected, choose the selected texture.
            if (menu.getSelectedOption() == i) {
                texButtonY += 18;
            }
            // if the mouse is inside this button, use the hovered texture.
            //else if (xMouse >= buttonXPos && xMouse < buttonXPos + btnSize
            //    && yMouse >= buttonYPos && yMouse < buttonYPos + btnSize
            //) {
            else if (hoveredItem == i) {
                texButtonY += 36;
            }

            blit(
                poseStack,
                buttonXPos,
                buttonYPos,
                0,
                texButtonY,
                btnSize,
                btnSize
            );
        }
    }

    /**
     * Renders the pictures of the items that can be chosen as options
     */
    protected void renderOptions () {
        var items = menu.getCurrentOptions();
        if (items == null) return;

        final int firstItem = firstRow * BUTTONS_PER_ROW; // inclusive
        final int lastItem = firstItem + VISIBLE_BUTTONS; // exclusive

        final int gap = 18;

        for (int i = firstItem; i < items.size() && i < lastItem; i++) {
            var iRel = i - firstItem;

            minecraft.getItemRenderer().renderAndDecorateItem(
                items.get(i),
                leftPos + 1 + BUTTON_MATRIX_X + (gap * (iRel % BUTTONS_PER_ROW)),
                topPos + 1 + BUTTON_MATRIX_Y + (gap * (iRel / BUTTONS_PER_ROW))
            );
        }
    }

    protected boolean isScrollbarActive () {
        var items = menu.getCurrentOptions();
        return items != null && items.size() > VISIBLE_BUTTONS;
    }

    protected int getOffscreenRows () {
        var items = menu.getCurrentOptions();
        if (items == null) return 0;

        return Math.max(
            // (number of rows minus one) - visible rows + one.
            ((items.size() - 1) / BUTTONS_PER_ROW) - VISIBLE_ROWS + 1,
            0
        );
    }

    /**
     * Returns the index of the item hovered by the mouse (in the button matrix).
     * If the mouse is outside the bounds of the button matrix, returns -1.
     * @param xMouse The x position of the mouse in the screen.
     * @param yMouse The y position of the mouse in the screen.
     */
    protected int indexAtMousePos (int xMouse, int yMouse) {
        // if the mouse is outside the bounds of the button matrix, nothing is hovered.
        if (isMouseInsideButtonMatrix(xMouse, yMouse) == false) return -1;

        var items = menu.getCurrentOptions();
        if (items == null) return -1;

        final int firstItem = firstRow * BUTTONS_PER_ROW; // inclusive
        final int gap = 18;

        // the distance (offset) of the mouse from the topleft of the button index.
        int xOffset = xMouse - leftPos - BUTTON_MATRIX_X;
        int yOffset = yMouse - topPos - BUTTON_MATRIX_Y;
        int col = xOffset / gap;
        int row = yOffset / gap;

        int itemIndex = (row * BUTTONS_PER_ROW) + col + firstItem;

        return itemIndex < items.size() ? itemIndex : -1;
    }

    protected boolean isMouseInsideButtonMatrix (int xMouse, int yMouse) {
        if (xMouse < leftPos + BUTTON_MATRIX_X) return false;
        if (xMouse >= leftPos + BUTTON_MATRIX_X + BUTTON_MATRIX_WIDTH) return false;
        if (yMouse < topPos + BUTTON_MATRIX_Y) return false;
        if (yMouse >= topPos + BUTTON_MATRIX_Y + BUTTON_MATRIX_HEIGHT) return false;
        return true;
    }
}

package azaria.kaisascore.gui.screen;

import azaria.kaisascore.KaisasCore;
import azaria.kaisascore.gui.SawmillMenu;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SawmillScreen extends AbstractCraftingStationScreen<SawmillMenu> {
    public static final int INPUT_MATRIX_X = 12;
    public static final int INPUT_MATRIX_Y = 17;
    public static final int RESULT_SLOT_X = 142;
    public static final int RESULT_SLOT_Y = 53;
    public static final int INVENTORY_X = 8;
    public static final int INVENTORY_Y = 120;

    public static final ResourceLocation BG_TEX_ID = new ResourceLocation(
        KaisasCore.MOD_ID, "textures/gui/container/sawmill.png"
    );

    public SawmillScreen (
        SawmillMenu menuType, Inventory playerInv, Component title
    ) {
        super(menuType, playerInv, title);

        inventoryLabelY += 36;
        imageWidth = 175;
        imageHeight = 201;
    }

    @Override
    protected void renderBg (
        PoseStack poseStack, float partialTick, int xMouse, int yMouse
    ) {
        renderStandardBackground(poseStack, BG_TEX_ID);
    }
}

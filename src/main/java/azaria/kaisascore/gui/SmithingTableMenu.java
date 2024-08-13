package azaria.kaisascore.gui;

import azaria.kaisascore.block.ModBlocks;
import azaria.kaisascore.block.entity.SmithingTableBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class SmithingTableMenu extends AbstractContainerMenu {
    public final SmithingTableBlockEntity _ent;
    private final Level _level;
    private final ContainerData _data;

    public SmithingTableMenu (int id, Inventory inv, FriendlyByteBuf extraData) {
        this(
            id,
            inv,
            inv.player.level.getBlockEntity(extraData.readBlockPos()),
            new SimpleContainerData(SmithingTableBlockEntity.CONTAINER_DATA_COUNT)
        );
    }

    public SmithingTableMenu (int id, Inventory inv, BlockEntity ent, ContainerData data) {
        super(ModMenuTypes.SMITHING_TABLE_MENU.get(), id);
        checkContainerSize(inv, SmithingTableBlockEntity.CONTAINER_SIZE);
        _ent = (SmithingTableBlockEntity)ent;
        _level = inv.player.level;
        _data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        _ent.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            addSlot(new SlotItemHandler(handler, 0, 12, 15));
            addSlot(new SlotItemHandler(handler, 1, 86, 15));
            addSlot(new SlotItemHandler(handler, 2, 86, 60));
        });

        addDataSlots(_data);
    }

    // TODO: 28:15
    @Override
    public ItemStack quickMoveStack (Player player, int index) {
        return null;
    }

    @Override
    public boolean stillValid (Player player) {
        return stillValid(
            ContainerLevelAccess.create(_level, _ent.getBlockPos()),
            player,
            ModBlocks.SMITHING_TABLE.get()
        );
    }

    public boolean isCrafting () {
        return _data.get(0) > 0;
    }

    public int getScaledProgress () {
        int progress = _data.get(0);
        int maxProgress = _data.get(1);
        int progressArrowHeight = 26;

        if (progress == 0) return 0;
        if (maxProgress == 0) return 0;

        return (progress * progressArrowHeight) / maxProgress;
    }

    private void addPlayerInventory (Inventory inventory) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                int index = (y * 9) + x + 9;
                addSlot(new Slot(inventory, index, 8 + (x * 18), 86 + (y * 18)));
            }
        }
    }

    private void addPlayerHotbar (Inventory inventory) {
        for (int x = 0; x < 9; x++) {
            addSlot(new Slot(inventory, x, 8 + (x * 18), 144));
        }
    }
}

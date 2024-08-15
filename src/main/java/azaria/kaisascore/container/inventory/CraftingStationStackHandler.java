package azaria.kaisascore.container.inventory;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class CraftingStationStackHandler extends ItemStackHandler {
    public CraftingStationStackHandler (int size) {
        super(size);
    }

    public NonNullList<ItemStack> getStacks () {
        return this.stacks;
    }
}

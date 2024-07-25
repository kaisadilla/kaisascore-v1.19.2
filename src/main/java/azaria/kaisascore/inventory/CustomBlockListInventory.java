package azaria.kaisascore.inventory;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class CustomBlockListInventory extends SimpleContainer {
    private int _size;

    public CustomBlockListInventory (NonNullList<ItemStack> items) {
        _size = items.size();
    }

    @Override
    public int getContainerSize () {
        return 0;
    }

    @Override
    public boolean isEmpty () {
        return false;
    }

    @Override
    public ItemStack getItem (int i) {
        return null;
    }

    @Override
    public ItemStack removeItem (int i, int i1) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate (int i) {
        return null;
    }

    @Override
    public void setItem (int i, ItemStack itemStack) {

    }

    @Override
    public void setChanged () {

    }

    @Override
    public boolean stillValid (Player player) {
        return false;
    }

    @Override
    public void clearContent () {
        for (int i = 0; i < _size; i++) {

        }
    }
}

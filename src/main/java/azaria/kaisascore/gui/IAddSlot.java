package azaria.kaisascore.gui;

import net.minecraft.world.inventory.Slot;

@FunctionalInterface
public interface IAddSlot {
    void run (Slot slot);
}

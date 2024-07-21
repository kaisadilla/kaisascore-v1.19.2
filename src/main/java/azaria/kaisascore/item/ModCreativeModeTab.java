package azaria.kaisascore.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab KAISACRAFT_TAB = new CreativeModeTab("kaisa_core") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.TITANIUM_INGOT.get());
        }
    };
}


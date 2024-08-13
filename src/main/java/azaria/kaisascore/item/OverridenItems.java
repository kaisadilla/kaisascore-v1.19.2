package azaria.kaisascore.item;

import azaria.kaisascore.KaisasCore;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class OverridenItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, KaisasCore.MINECRAFT_ID
    );

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

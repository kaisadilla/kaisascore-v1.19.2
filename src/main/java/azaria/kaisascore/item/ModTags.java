package azaria.kaisascore.item;

import azaria.kaisascore.KaisasCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = tag(
            "needs_titanium_tool"
        );

        private static TagKey<Block> tag (String name) {
            return BlockTags.create(new ResourceLocation(KaisasCore.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag (String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static class Forge {
            public static class Ingots {
                public static final TagKey<Item> TIN = forgeTag("ingots/tin");
                public static final TagKey<Item> LEAD = forgeTag("ingots/lead");
                public static final TagKey<Item> BRONZE = forgeTag("ingots/bronze");
                public static final TagKey<Item> NICKEL = forgeTag("ingots/nickel");
                public static final TagKey<Item> STEEL = forgeTag("ingots/steel");
                public static final TagKey<Item> CONSTANTAN = forgeTag("ingots/constantan");
                public static final TagKey<Item> INVAR = forgeTag("ingots/invar");
                public static final TagKey<Item> SILVER = forgeTag("ingots/silver");
                public static final TagKey<Item> ELECTRUM = forgeTag("ingots/electrum");
                public static final TagKey<Item> PLATINUM = forgeTag("ingots/platinum");
                public static final TagKey<Item> TITANIUM = forgeTag("ingots/titanium");
            }
        }

        private static TagKey<Item> tag (String name) {
            return ItemTags.create(new ResourceLocation(KaisasCore.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag (String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}


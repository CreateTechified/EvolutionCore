package io.github.createtechified.evolutioncore.common.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("removal")
public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_COPPER_TOOL = BlockTag("needs_copper_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = BlockTag("needs_bronze_tool");
        public static final TagKey<Block> NEEDS_UNSTABLE_TOOL = BlockTag("needs_unstable_tool");
        public static final TagKey<Block> NEEDS_MANYULLYN_TOOL = BlockTag("needs_manyullyn_tool");
        public static final TagKey<Block> MINEABLE_WITH_HAMMER = BlockTag("mineable_with_hammer");

        private static TagKey<Block> BlockTag(String name) {
            return BlockTags.create(new ResourceLocation(Reference.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> INGOTS_BRONZE = ItemTag("ingots/bronze");
        public static final TagKey<Item> INGOTS_UNSTABLE = ItemTag("ingots/unstable");
        public static final TagKey<Item> INGOTS_MANYULLYN = ItemTag("ingots/manyullyn");

        private static TagKey<Item> ItemTag(String name) {
            return ItemTags.create(new ResourceLocation(Reference.MODID, name));
        }
    }
}

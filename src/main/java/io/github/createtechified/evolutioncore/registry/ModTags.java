package io.github.createtechified.evolutioncore.registry;

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
        public static final TagKey<Block> NEEDS_FLINT_TOOL = BlockTag("needs_flint_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = BlockTag("needs_copper_tool");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = BlockTag("needs_bronze_tool");

        private static TagKey<Block> BlockTag(String name) {
            return BlockTags.create(new ResourceLocation(Reference.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> INGOTS_BRONZE = ItemTag("ingots/bronze");

        private static TagKey<Item> ItemTag(String name) {
            return ItemTags.create(new ResourceLocation(Reference.MODID, name));
        }
    }
}

package io.github.createtechified.evolutioncore.common.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class EvoTags {
    public static class Blocks {
        public static final TagKey<Block> MINEABLE_WITH_HAMMER = BlockTag("mineable_with_hammer");

        private static TagKey<Block> BlockTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HIDDEN_FROM_RECIPE_VIEWERS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "hidden_from_recipe_viewers"));

        private static TagKey<Item> ItemTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Reference.MODID, name));
        }
    }
}

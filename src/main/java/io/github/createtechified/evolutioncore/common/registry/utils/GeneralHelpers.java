package io.github.createtechified.evolutioncore.common.registry.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class GeneralHelpers {
    public static Item getItemFromNamespaceAndID(String namespace, String id) {
        return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }
    public static Block getBlockFromNamespaceAndID(String namespace, String id) {
        return ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }
}

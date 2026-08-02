package io.github.createtechified.evolutioncore.common.registry.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GeneralHelpers {
    public static Item getItemFromNamespaceAndID(String namespace, String id) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }
    public static Block getBlockFromNamespaceAndID(String namespace, String id) {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }
}

package io.github.createtechified.evolutioncore.common.registry.utils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.Arrays;

public class GeneralHelpers {
    public static Item getItemFromNamespaceAndID(String namespace, String id) {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }
    public static Block getBlockFromNamespaceAndID(String namespace, String id) {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }

    public static Fluid getFluidFromNamespaceAndID(String namespace, String fluid) {
        return BuiltInRegistries.FLUID.get(ResourceLocation.fromNamespaceAndPath(namespace, fluid));
    }

    public static ItemStack[] filterItemStackForEmptyStacks(ItemStack... outputs) {
        return Arrays.stream(outputs)
                .filter(stack -> stack != null && !stack.isEmpty())
                .toArray(ItemStack[]::new);
    }
}

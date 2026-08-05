package io.github.createtechified.evolutioncore.common.registry.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;

public class GeneralHelpers {
    public static Item getItemFromNamespaceAndID(String namespace, String id) {
        return ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }
    public static Block getBlockFromNamespaceAndID(String namespace, String id) {
        return ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, id));
    }

    public static Fluid getFluidFromNamespaceAndID(String namespace, String fluid) {
        return ForgeRegistries.FLUIDS.getValue(ResourceLocation.fromNamespaceAndPath(namespace, fluid));
    }

    public static ItemStack[] filterItemStackForEmptyStacks(ItemStack... outputs) {
        return Arrays.stream(outputs)
                .filter(stack -> stack != null && !stack.isEmpty())
                .toArray(ItemStack[]::new);
    }
}

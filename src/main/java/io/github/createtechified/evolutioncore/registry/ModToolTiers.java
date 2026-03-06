package io.github.createtechified.evolutioncore.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

@SuppressWarnings("removal")
public class ModToolTiers {
    public static final Tier FLINT = TierSortingRegistry.registerTier(new ForgeTier(1, 191, 2.5f, 0.5f, 13, ModTags.Blocks.NEEDS_FLINT_TOOL, () -> Ingredient.of(Items.FLINT)), new ResourceLocation(Reference.MODID, "flint"), List.of(Tiers.WOOD), List.of(Tiers.GOLD));
    public static final Tier COPPER = TierSortingRegistry.registerTier(new ForgeTier((int) 1.5, 191, 2.5f, 0.5f, 13, ModTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)), new ResourceLocation(Reference.MODID, "copper"), List.of(Tiers.STONE), List.of());
    public static final Tier BRONZE = TierSortingRegistry.registerTier(new ForgeTier((int) 1.5, 191, 2.5f, 0.5f, 13, ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_BRONZE)), new ResourceLocation(Reference.MODID, "bronze"), List.of(ModToolTiers.COPPER), List.of(Tiers.IRON));

    // Make sure this is at the bottom...
    public static final List<Tier> TIERS = List.of(FLINT, COPPER, BRONZE);
}

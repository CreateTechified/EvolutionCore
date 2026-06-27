package io.github.createtechified.evolutioncore.common.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

@SuppressWarnings("removal")
public class ModToolTiers {
    public static final Tier COPPER = TierSortingRegistry.registerTier(new ForgeTier(2, 191, 2.5f, 0.5f, 13, ModTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(Tags.Items.INGOTS_COPPER)), new ResourceLocation(Reference.MODID, "copper"), List.of(Tiers.STONE), List.of(Tiers.IRON));
    public static final Tier BRONZE = TierSortingRegistry.registerTier(new ForgeTier(4, 191, 2.5f, 0.5f, 13, ModTags.Blocks.NEEDS_BRONZE_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_BRONZE)), new ResourceLocation(Reference.MODID, "bronze"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
    public static final Tier UNSTABLE = TierSortingRegistry.registerTier(new ForgeTier(6, 0, 8, 8, 20, ModTags.Blocks.NEEDS_UNSTABLE_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_UNSTABLE)), new ResourceLocation(Reference.MODID, "unstable"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
    public static final Tier MANYULLYN = TierSortingRegistry.registerTier(new ForgeTier(9, 1250, 6.5f, 3.5f, 30, ModTags.Blocks.NEEDS_MANYULLYN_TOOL, () -> Ingredient.of(ModTags.Items.INGOTS_MANYULLYN)), new ResourceLocation(Reference.MODID, "manyullyn"), List.of(Tiers.NETHERITE), List.of()); // technically incorrect but fixes npe

    // Make sure this is at the bottom of registry...
    public static final List<Tier> TIERS = List.of(COPPER, BRONZE, UNSTABLE, MANYULLYN);
}

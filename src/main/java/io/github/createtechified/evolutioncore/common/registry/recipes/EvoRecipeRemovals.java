package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.GTCEu;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class EvoRecipeRemovals {
    public static void init(Consumer<ResourceLocation> p) {
        p.accept(GTCEu.id("shaped/steam_oven_from_lp"));
        p.accept(GTCEu.id("shaped/steam_oven_from_hp"));
        p.accept(GTCEu.id("macerator/macerate_steam_oven"));
        p.accept(GTCEu.id("arc_furnace/arc_steam_oven"));
        p.accept(GTCEu.id("shaped/steam_grinder_from_lp"));
        p.accept(GTCEu.id("shaped/steam_grinder_from_hp"));
        p.accept(GTCEu.id("macerator/macerate_steam_grinder"));
        p.accept(GTCEu.id("arc_furnace/arc_steam_grinder"));
    }
}

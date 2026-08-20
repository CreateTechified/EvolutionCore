package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class EvoRecipeRemovals {
    public static void init(Consumer<ResourceLocation> p) {
        shaped(p);
        macerator(p);
        arcfurnace(p);
        assembler(p);
        pbfold(p);
    }

    private static void shaped(Consumer<ResourceLocation> p) {
        // Circuits
        p.accept(gtshaped("vacuum_tube"));

        // MB Controllers
        if (Reference.GT_SteelSteamRecipes.get()) {
            p.accept(gtshaped("steam_oven"));
            p.accept(gtshaped("steam_grinder"));
        } else {
            p.accept(gtshaped("steam_oven_from_lp"));
            p.accept(gtshaped("steam_oven_from_hp"));
            p.accept(gtshaped("steam_grinder_from_lp"));
            p.accept(gtshaped("steam_grinder_from_hp"));
        }
        p.accept(gtshaped("charcoal_pile_igniter"));
    }
    private static void macerator(Consumer<ResourceLocation> p) {
        p.accept(gtmace("steam_oven"));
        p.accept(gtmace("steam_grinder"));
    }
    private static void arcfurnace(Consumer<ResourceLocation> p) {
        p.accept(gtarc("steam_oven"));
        p.accept(gtarc("steam_grinder"));
    }
    private static void assembler(Consumer<ResourceLocation> p) {
        p.accept(gtass("vacuum_tube_plain"));
        p.accept(gtass("vacuum_tube_red_alloy"));
        p.accept(gtass("vacuum_tube_red_alloy_annealed"));
    }
    private static void pbfold(Consumer<ResourceLocation> p) {
        p.accept(pbf("coal_gem"));
        p.accept(pbf("coal_dust"));
        p.accept(pbf("charcoal_gem"));
        p.accept(pbf("charcoal_dust"));
        p.accept(pbf("coke_gem"));
        p.accept(pbf("coke_dust"));
        p.accept(pbf("coal_block"));
        p.accept(pbf("charcoal_block"));
        p.accept(pbf("coke_block"));
        p.accept(pbf("coal_gem_wrought"));
        p.accept(pbf("coal_dust_wrought"));
        p.accept(pbf("charcoal_gem_wrought"));
        p.accept(pbf("charcoal_dust_wrought"));
        p.accept(pbf("coke_gem_wrought"));
        p.accept(pbf("coke_dust_wrought"));
        p.accept(pbf("coal_block_wrought"));
        p.accept(pbf("charcoal_block_wrought"));
        p.accept(pbf("coke_block_wrought"));
    }

    private static ResourceLocation gtshaped(String n) {return GTCEu.id("shaped/" + n);}
    private static ResourceLocation gtmace(String n) {return GTCEu.id("macerator/macerate_" + n);}
    private static ResourceLocation gtarc(String n) {return GTCEu.id("arc_furnace/arc_" + n);}
    private static ResourceLocation gtass(String n) {return GTCEu.id("assembler/" + n);}
    private static ResourceLocation pbf(String n) {return GTCEu.id("primitive_blast_furnace/steel_from_" + n);}
}

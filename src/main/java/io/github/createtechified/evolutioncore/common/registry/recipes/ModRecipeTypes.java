package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;

public class ModRecipeTypes {
    public static void init() {
    }

    public static final GTRecipeType PRIMITIVE_ALLOY_SMELTER = GTRecipeTypes.register("primitive_alloy_smelter", "primitive").setMaxIOSize(3,2,0,0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FURNACE);
    public static final GTRecipeType STEAM_BLAST_FURNACE = GTRecipeTypes.register("steam_blast_furnace", "steam").setMaxIOSize(2, 2, 0, 0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FURNACE);
}

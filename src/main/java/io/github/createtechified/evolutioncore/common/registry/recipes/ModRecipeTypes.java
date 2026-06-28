package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.api.capability.recipe.IO.IN;

public class ModRecipeTypes {
    public static void init() {
    }

    public static final GTRecipeType PRIMITIVE_ALLOY_SMELTER = GTRecipeTypes.register("primitive_alloy_smelter", "primitive").setMaxIOSize(3,2,0,0).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.FURNACE);
    public static final GTRecipeType STEAM_BLAST_FURNACE = GTRecipeTypes.register("steam_blast_furnace", "steam").setMaxIOSize(2, 2, 0, 0).setSteamProgressBar(GuiTextures.PROGRESS_BAR_ARROW_STEAM, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.FURNACE);
}

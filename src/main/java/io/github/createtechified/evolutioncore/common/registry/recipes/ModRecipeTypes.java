package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
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
    public static final GTRecipeType STEEL_GREENHOUSE = GTRecipeTypes.register("steam_greenhouse", "agriculture").setMaxIOSize(2, 5, 3, 0).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.BATH);
    public static final GTRecipeType PRIMITIVE_ORE_FACTORY = GTRecipeTypes.register("primitive_ore_factory", "ore_processing").setMaxIOSize(2,6,0, 0).setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType STEAM_ORE_FACTORY = GTRecipeTypes.register("steam_ore_factory", "ore_processing").setMaxIOSize(1, 6, 1, 0).setSteamProgressBar(GuiTextures.PROGRESS_BAR_MACERATE_STEAM, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType ELECTRIC_ORE_FACTORY = GTRecipeTypes.register("electric_ore_factory", "ore_processing").setMaxIOSize(1, 6, 1, 0).setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType ORE_PROCESSING_PLANT = GTRecipeTypes.register("ore_processing_plant", "ore_processing").setMaxIOSize(1, 6, 1, 0).setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType BULK_ORE_PROCESSING_PLANT = GTRecipeTypes.register("bulk_ore_processing_plant", "ore_processing").setMaxIOSize(1, 6, 1, 0).setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType LARGE_CHEMICAL_PLANT = GTRecipeTypes.register("large_chemical_plant", "chemical_reactor").setMaxIOSize(6, 6, 6, 6).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.CHEMICAL);
    public static final GTRecipeType CHEMICAL_LINE_REDUCTION = GTRecipeTypes.register("chemical_line_reduction", "chemical_reactor").setMaxIOSize(6, 6, 6, 6).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.CHEMICAL);
    public static final GTRecipeType FISSION_REACTOR_FUELS = GTRecipeTypes.register("simple_fission_reactor", "nuclear_reactor").setMaxIOSize(1, 1, 1, 0).setEUIO(IO.OUT).setProgressBar(GuiTextures.PROGRESS_BAR_EXTRUDER, ProgressTexture.FillDirection.LEFT_TO_RIGHT).setSound(GTSoundEntries.ARC);
}

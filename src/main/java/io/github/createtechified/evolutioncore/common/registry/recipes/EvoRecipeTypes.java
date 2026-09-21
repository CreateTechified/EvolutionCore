package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.entry.GTRecipeTypeEntry;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.world.item.crafting.RecipeType;

public class EvoRecipeTypes {
    public static void init() {}

    public static final GTRecipeTypeEntry PRIMITIVE_BLAST_FURNACE = Reference.REGISTRATE.recipeType("primitive_blast_furnace", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2, 2, 0, 0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FIRE).setIconSupplier(() -> GTMultiMachines.PRIMITIVE_BLAST_FURNACE.asStack()).register(); // Don't change to method ref (::) else it'll break.
    public static final GTRecipeTypeEntry PRIMITIVE_ALLOY_SMELTER = Reference.REGISTRATE.recipeType("primitive_alloy_smelter", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(3,2,0,0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FURNACE).register();
    public static final GTRecipeTypeEntry PRIMITIVE_ORE_FACTORY = Reference.REGISTRATE.recipeType("primitive_ore_factory", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2,6,1, 0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER).register();
    public static final GTRecipeTypeEntry STEAM_BLAST_FURNACE = Reference.REGISTRATE.recipeType("steam_blast_furnace", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2, 2, 0, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FURNACE).register();
    public static final GTRecipeTypeEntry STEAM_ORE_FACTORY = Reference.REGISTRATE.recipeType("steam_ore_factory", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER).register();
    public static final GTRecipeTypeEntry STEEL_GREENHOUSE = Reference.REGISTRATE.recipeType("steel_greenhouse", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2, 5, 3, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.BATH).register();
    public static final GTRecipeTypeEntry ELECTRIC_ORE_FACTORY = Reference.REGISTRATE.recipeType("electric_ore_factory", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER).register();
    public static final GTRecipeTypeEntry ORE_PROCESSING_PLANT = Reference.REGISTRATE.recipeType("ore_processing_plant", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER).register();
    public static final GTRecipeTypeEntry BULK_ORE_PROCESSING_PLANT = Reference.REGISTRATE.recipeType("bulk_ore_processing_plant", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER).register();
    public static final GTRecipeTypeEntry LARGE_CHEMICAL_PLANT = Reference.REGISTRATE.recipeType("large_chemical_plant", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(6, 6, 6, 6).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW_MULTIPLE)).setSound(GTSoundEntries.CHEMICAL).register();
    public static final GTRecipeTypeEntry CHEMICAL_LINE_REDUCTION = Reference.REGISTRATE.recipeType("chemical_line_reduction", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(6, 6, 6, 6).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW_MULTIPLE)).setSound(GTSoundEntries.CHEMICAL).register();
    public static final GTRecipeTypeEntry FISSION_REACTOR_FUELS = Reference.REGISTRATE.recipeType("simple_fission_reactor", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 1, 1, 0).setEUIO(IO.OUT).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_EXTRUDER)).setSound(GTSoundEntries.ARC).register();
    public static final GTRecipeTypeEntry VACUUM_CHAMBER_RECIPES = Reference.REGISTRATE.recipeType("vacuum_chamber", GTRecipeTypes.ELECTRIC).setEUIO(IO.IN).setMaxIOSize(1, 1, 0, 0).UI(builder -> builder.setSlotOverlay(IO.IN, 0, ItemRecipeCapability.CAP, GTGuiTextures.COMPRESSOR_OVERLAY).setSlotOverlay(IO.OUT, 0,ItemRecipeCapability.CAP, GTGuiTextures.COMPRESSOR_OVERLAY).setProgressBar(GTGuiTextures.PROGRESS_GAS_COLLECTOR)).setSound(GTSoundEntries.COOLING).register();
}

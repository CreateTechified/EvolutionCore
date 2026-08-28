package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import net.minecraft.world.item.crafting.RecipeType;

public class EvoRecipeTypes {
    public static void init() {}

    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        return GTRecipeTypes.register(EvolutionCoreMod.id(name), group, proxyRecipes);
    }

    public static final GTRecipeType PRIMITIVE_BLAST_FURNACE = register("primitive_blast_furnace", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2, 2, 0, 0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FIRE).setIconSupplier(() -> GTMultiMachines.PRIMITIVE_BLAST_FURNACE.asStack()); // Don't change to method ref (::) else it'll break.
    public static final GTRecipeType PRIMITIVE_ALLOY_SMELTER = register("primitive_alloy_smelter", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(3,2,0,0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FURNACE);
    public static final GTRecipeType PRIMITIVE_ORE_FACTORY = register("primitive_ore_factory", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2,6,1, 0).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType STEAM_BLAST_FURNACE = register("steam_blast_furnace", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2, 2, 0, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.FURNACE);
    public static final GTRecipeType STEAM_ORE_FACTORY = register("steam_ore_factory", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType STEEL_GREENHOUSE = register("steel_greenhouse", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(2, 5, 3, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW)).setSound(GTSoundEntries.BATH);
    public static final GTRecipeType ELECTRIC_ORE_FACTORY = register("electric_ore_factory", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType ORE_PROCESSING_PLANT = register("ore_processing_plant", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType BULK_ORE_PROCESSING_PLANT = register("bulk_ore_processing_plant", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 6, 1, 0).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE)).setSound(GTSoundEntries.BOILER);
    public static final GTRecipeType LARGE_CHEMICAL_PLANT = register("large_chemical_plant", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(6, 6, 6, 6).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW_MULTIPLE)).setSound(GTSoundEntries.CHEMICAL);
    public static final GTRecipeType CHEMICAL_LINE_REDUCTION = register("chemical_line_reduction", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(6, 6, 6, 6).setEUIO(IO.IN).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW_MULTIPLE)).setSound(GTSoundEntries.CHEMICAL);
    public static final GTRecipeType FISSION_REACTOR_FUELS = register("simple_fission_reactor", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(1, 1, 1, 0).setEUIO(IO.OUT).UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_EXTRUDER)).setSound(GTSoundEntries.ARC);
    public static final GTRecipeType VACUUM_CHAMBER_RECIPES = register("vacuum_chamber", GTRecipeTypes.ELECTRIC).setEUIO(IO.IN).setMaxIOSize(1, 1, 0, 0).UI(builder -> builder.setSlotOverlay(IO.IN, 0, ItemRecipeCapability.CAP, GTGuiTextures.COMPRESSOR_OVERLAY).setSlotOverlay(IO.OUT, 0, ItemRecipeCapability.CAP, GTGuiTextures.COMPRESSOR_OVERLAY).setProgressBar(GTGuiTextures.PROGRESS_GAS_COLLECTOR)).setSound(GTSoundEntries.COOLING);
}

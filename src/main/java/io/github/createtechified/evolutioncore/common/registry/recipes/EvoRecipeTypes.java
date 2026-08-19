package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.category.GTRecipeCategory;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@SuppressWarnings("deprecation")
public class EvoRecipeTypes {
    public static void init() {}

    public static GTRecipeCategory register(String categoryName, GTRecipeType recipeType) {
        GTRecipeCategory category = new GTRecipeCategory(categoryName, recipeType);
        GTRegistries.RECIPE_CATEGORIES.register(category.registryKey, category);
        return category;
    }

    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        var recipeType = new GTRecipeType(EvolutionCoreMod.id(name), group, proxyRecipes);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }

    public static final GTRecipeType NULL = register("null", GTRecipeTypes.DUMMY); // This only exists to be a null recipe for removing multiblocks.

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

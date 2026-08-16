package io.github.createtechified.evolutioncore.datagen.providers;

import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LanguageHandler {
    public static void init(RegistrateLangProvider provider) {
        for (var recipeType : GTRegistries.RECIPE_TYPES) {
            if (recipeType.registryName.getNamespace().equals("evolutioncore")) provider.add(recipeType.registryName.toLanguageKey(), RegistrateLangProvider.toEnglishName(recipeType.registryName.getPath()));
        } // Stupid solutions to stupid problems. Works though.
        // TODO: make these better
        provider.add("evolutioncore.tooltip.steam_vent", "Exhausts Steam from Multiblocks");
        provider.add("evolutioncore.tooltip.steam_vent.warn", "⚠ | Obstruction of output prevents the machine from running more recipes.");
        provider.add("evolutioncore.tooltip.steam_assembler", "Assembling with Steam!");
        provider.add("evolutioncore.tooltip.steam_centrifuge", "Centrifuging your Resin, among many others.");
        provider.add("evolutioncore.tooltip.steam_ore_washer", "Washing your Ores!");
        provider.add("evolutioncore.tooltip.steam_vacuum_chamber", "Sealing your Vacuum Tubes, anong other things.");
        provider.add("evolutioncore.tooltip.primitive_alloy_kiln", "Alloying with Fire(bricks)!");
        provider.add("evolutioncore.tooltip.steam_alloy_kiln.l", "Steam-charged Parallelized Alloying Machine");
        provider.add("evolutioncore.tooltip.steam_alloy_kiln.h", "Steam-charged Parallelized Alloying Machine, reinforced with Steel to sustain High Pressures.");
        provider.add("evolutioncore.tooltip.steam_blast_furnace.h", "Faster Blast Smelting, brought to you by Steam!");
        provider.add("evolutioncore.tooltip.steam_grinder.l", "Grinding with Steam!");
        provider.add("evolutioncore.tooltip.steam_grinder.h", "Grinding with Steam! Reinforced with Steel to sustain High Pressures.");
        provider.add("evolutioncore.tooltip.steam_oven.l", "A Steam Oven!");
        provider.add("evolutioncore.tooltip.steam_oven.h", "A Steam Oven! Reinforced with Steel to sustain High Pressures");
        provider.add("evolutioncore.tooltip.steam_separator.l", "Seperating.. with Steam?");
        provider.add("evolutioncore.tooltip.steam_separator.h", "Seperating.. with Steam? Reinforced with Steel to sustain High Pressures.");
        provider.add("evolutioncore.tooltip.steam_separator.h.apology", "I am genuinely sorry that I made you do this. Enjoy the parallels!");
        provider.add("evolutioncore.tooltip.steam_purifier.l", "Washing with Steam!");
        provider.add("evolutioncore.tooltip.steam_purifier.h", "Washing with Steam! Reinforced with Steel to sustain High Pressures.");
        provider.add("evolutioncore.tooltip.steam_impact_forge.l", "Using Steam to create powerful impacts.");
        provider.add("evolutioncore.tooltip.steam_impact_forge.h", "Using Steam to create powerful impacts, reinforced with Steel to sustain High Pressures.");
        provider.add("evolutioncore.tooltip.primitive_ore_factory", "Processing your Ores with Fire(bricks)!");
        provider.add("evolutioncore.tooltip.steam_ore_factory.l", "A Steam-Powered Ore Factory to process all your ores.");
        provider.add("evolutioncore.tooltip.steam_ore_factory.h", "A Steam-Powered Ore Factory to process all your ores, reinforced with Steel to sustain High Pressures.");
        provider.add("evolutioncore.tooltip.electric_ore_factory", "An Electric-Powered Ore Factory to process all your ores.");
        provider.add("evolutioncore.tooltip.ore_processing_factory", "A mid-tier Ore Processing Factory to process all your ores.\nHas Perfect Overclocking, but no Parallelization.");
        provider.add("evolutioncore.tooltip.ore_processing_plant", "A high-tier Ore Processing Plant to process all your ores.\nCan Parallelize with Parallel Control Hatchs.");
        provider.add("evolutioncore.tooltip.bulk_ore_processing_plant", "A beast which can process large amounts of ore in seconds.\nCan Parallelize with Parallel Control Hatchs.");
        provider.add("evolutioncore.tooltip.steel_greenhouse", "A simple Greenhouse to make Wood!");
        provider.add("evolutioncore.tooltip.fusion_alloying_chamber", "Can Parallelize with Parallel Control Hatches.\nFor every 900K §7above the recipe temperature, a multiplicative §r95% §7energy multiplier is applied pre-overclocking.§r\nFor every 1800K §7above the recipe temperature, one overclock becomes §r100% efficient §7(perfect overclock).§r\nFor every voltage tier above §bMV§7, temperature is increased by §r100K"); // This line proves why I need an ultrawide... lol
        provider.add("evolutioncore.tooltip.large_chemical_plant", "An Advanced Chemical Reactor.\nCan Parallelize with Parallel Control Hatches.");
        provider.add("evolutioncore.tooltip.simple_fission_reactor", "A simple fission reactor, utilizes fuel rods to generate energy.\n§c⚠ | Safety has not been proven. Meltdowns may occur.");
    }
}
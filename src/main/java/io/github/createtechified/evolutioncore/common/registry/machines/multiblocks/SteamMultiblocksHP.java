package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks;

import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.steam.HPSteamParallelMultiblockMachine;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoMultiParts;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;

@SuppressWarnings("unused")
public class SteamMultiblocksHP {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition HP_STEAM_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("hp_steam_alloy_kiln", HPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifier(HPSteamParallelMultiblockMachine::recipeModifier, true)
            .appearanceBlock(EvoBlocks.HP_STEAM_MACHINE_CASING)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" FFF ", " MMM ", " MMM ", " MMM ", "  M  ", "     ", "     ")
                    .slice("FMMMF", "MG#GM", "M###M", "M###M", " M#M ", " MMM ", " BBB ")
                    .slice("FMMMF", "M#P#M", "M#P#M", "M#P#M", "M#P#M", " MVM ", " B B ")
                    .slice("FMMMF", "MG#GM", "M###M", "M###M", " M#M ", " MMM ", " BBB ")
                    .slice(" FFF ", " MCM ", " MMM ", " MMM ", "  M  ", "     ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('M', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get()).setMinGlobalLimited(30)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1).setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1).setMaxGlobalLimited(2)))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('F', Predicates.blocks(EvoBlocks.HP_STEAM_FIREBOX_CASING.get()))
                    .where('B', Predicates.blocks(GTBlocks.STEEL_HULL.get()))
                    .where('V', Predicates.abilities(EvoMultiParts.STEAM_VENT))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"), EvolutionCoreMod.id("block/machines/hp_steam_alloy_kiln"))
            .langValue("High Pressure Steam Alloy Kiln")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_alloy_kiln.h").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.STEEL.getId())
            .register();

    public static final MultiblockMachineDefinition HP_STEAM_GRINDER = Reference.REGISTRATE
            .multiblock("hp_steam_grinder", HPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(EvoBlocks.HP_STEAM_MACHINE_CASING)
            .recipeType(GTRecipeTypes.MACERATOR_RECIPES)
            .recipeModifier(HPSteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("WBBBW", "WBVBW", "WBBBW")
                    .slice("BBBBB", "BG#GB", "B#F#B")
                    .slice("BBBBB", "B###B", "BFFFB")
                    .slice("BBBBB", "BG#GB", "B#F#B")
                    .slice("WBBBW", "WBCBW", "WBBBW")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where('B', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('F', Predicates.frames(GTMaterials.Steel))
                    .where('V', Predicates.abilities(EvoMultiParts.STEAM_VENT))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_wall")))))
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"), EvolutionCoreMod.id("block/machines/hp_steam_grinder"))
            .langValue("High Pressure Steam Grinder")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_grinder.h").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.STEEL.getId())
            .register();

    public static final MultiblockMachineDefinition HP_STEAM_OVEN = Reference.REGISTRATE
            .multiblock("hp_steam_oven", HPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(EvoBlocks.HP_STEAM_MACHINE_CASING)
            .recipeType(GTRecipeTypes.FURNACE_RECIPES)
            .recipeModifier(HPSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" FFF ", " W W ", " HHH ", "     ")
                    .slice("FBBBF", "WBBBW", "HBBBH", " VQV ")
                    .slice("FBBBF", " H#H ", "HBMBH", " Q#Q ")
                    .slice("FBBBF", "WBCBW", "HBBBH", " VQV ")
                    .slice(" FFF ", " W W ", " HHH ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('B', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get()))
                    .where('H', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('M', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(1))
                    .where('F', Predicates.blocks(EvoBlocks.HP_STEAM_FIREBOX_CASING.get()))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_wall")))))
                    .where('V', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_brick_wall")))))
                    .where('Q', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_bricks")))))
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"), EvolutionCoreMod.id("block/machines/hp_steam_oven"))
            .langValue("High Pressure Steam Oven")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_oven.h").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.STEEL.getId())
            .register();

    public static final MultiblockMachineDefinition HP_STEAM_SEPARATOR = Reference.REGISTRATE
            .multiblock("hp_steam_separator", HPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(EvoBlocks.HP_STEAM_MACHINE_CASING)
            .recipeType(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifier(HPSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" WFFFFFFFFFFFW ", " WBBBW   WBBBW ", " WBGBW   WBGBW ", " WBGBW   WBGBW ", " WBGBW   WBGBW ", " WBBBW   WBBBW ", "  BBBW   WBBB  ", "               ", "               ")
                    .slice("WFBBBBBBBBBBBFW", "WBJ#JBBBBBJ JBW", "WB###BBGBB###BW", "WB###BBGBB###BW", "WB###BBGBB   BW", "WB###BBBBB###BW", " BBBBB   BBBBB ", "  WBW     WBW  ", "               ")
                    .slice("FBBBBBBPBBBBBBF", "BJ###JG GJ###JB", "B#####G G#####B", "B#####G G#####B", "B#####G G#####B", "B#####BBB#####B", "BBBBBBBBBBBBBBB", " WBBBW   WBBBW ", "  BBB     BBB  ")
                    .slice("FBBPPPPPPPPPBBF", "B##P##G G##P##B", "G##P##G G##P##G", "G##P##G G##P##G", "G##P##G G##P##G", "B##P##BBB##P##B", "BBBPBBBBBBBPBBB", " BBMBB   BBMBB ", "  B#B     B#B  ")
                    .slice("FBBBBBBPBBBBBBF", "BJ###JG GJ###JB", "B#####G G#####B", "B#####G G#####B", "B#####G G#####B", "B#####BBB#####B", "BBBBBBBBBBBBBBB", " WBBBW   WBBBW ", "  BBB     BBB  ")
                    .slice("WFBBBBBBBBBBBFW", "WBJ#JBBCBBJ JBW", "WB###BBGBB###BW", "WB###BBGBB###BW", "WB###BBGBB   BW", "WB###BBBBB###BW", " BBBBB   BBBBB ", "  WBW     WBW  ", "               ")
                    .slice(" WFFFFFFFFFFFW ", " WBBBW   WBBBW ", " WBGBW   WBGBW ", " WBGBW   WBGBW ", " WBGBW   WBGBW ", " WBBBW   WBBBW ", "  BBBW   WBBB  ", "               ", "               ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('B', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('F', Predicates.blocks(EvoBlocks.HP_STEAM_FIREBOX_CASING.get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('J', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('G', Predicates.blocks(AllPaletteBlocks.FRAMED_GLASS.get()))
                    .where('M', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(2))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_wall")))))
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"), EvolutionCoreMod.id("block/machines/hp_steam_separator"))
            .langValue("High Pressure Steam Separator")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_separator.h").withStyle(ChatFormatting.GRAY), Component.translatable("evolutioncore.tooltip.steam_separator.h.apology").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.STEEL.getId())
            .register();

    public static final MultiblockMachineDefinition HP_STEAM_PURIFIER = Reference.REGISTRATE
            .multiblock("hp_steam_purifier", HPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(EvoBlocks.HP_STEAM_MACHINE_CASING)
            .recipeType(GTRecipeTypes.ORE_WASHER_RECIPES)
            .recipeModifier(HPSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  BBBBB  ", "  WGGGW  ", "  WGGGW  ", "  BBBBB  ", "         ", "         ")
                    .slice(" BBBBBBB ", " WGSSSGW ", " WG###GW ", " BBGGGBB ", "         ", "         ")
                    .slice(" BBBBBBB ", " GSSSSSG ", " G#####G ", " BGGBGGB ", "         ", "         ")
                    .slice(" BBBBBBB ", " GSSPSSG ", " G##P##G ", " BGBPBGB ", "    P    ", "    P    ")
                    .slice(" BBBBBBB ", " GSSSSSG ", " G#####G ", " BGGBGGB ", "         ", "    P    ")
                    .slice(" BBBBBBB ", " WGSSSGW ", " WG###GW ", " BBGGGBB ", "         ", "    P    ")
                    .slice("  BBBBB  ", "  WGGGW  ", "  WGGGW  ", "  BBBBB  ", "         ", "    P    ")
                    .slice("         ", "         ", "         ", "         ", "         ", "    P    ")
                    .slice("WHFFFHHHW", "WHGGGHHHW", "WHHHHHHHW", "         ", "         ", "    P    ")
                    .slice("HHHHHHHHH", "HBSSPPPBH", "HHGGPHVHH", "    P    ", "    P    ", "    P    ")
                    .slice("WHFFFHHHW", "WHGGGHCHW", "WHHHHHHHW", "         ", "         ", "         ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('B', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get()))
                    .where('H', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('F', Predicates.blocks(EvoBlocks.HP_STEAM_FIREBOX_CASING.get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('S', Predicates.fluids(Fluids.WATER))
                    .where('G', Predicates.blocks(AllPaletteBlocks.FRAMED_GLASS.get()))
                    .where('V', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(1))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_wall")))))
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"), EvolutionCoreMod.id("block/machines/hp_steam_purifier"))
            .langValue("High Pressure Steam Purifier")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_purifier.h").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.STEEL.getId())
            .register();

    public static final MultiblockMachineDefinition HP_STEAM_BLAST_FURNACE = Reference.REGISTRATE
            .multiblock("hp_steam_blast_furnace", HPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(EvoBlocks.HP_STEAM_MACHINE_CASING)
            .recipeType(EvoRecipeTypes.STEAM_BLAST_FURNACE)
            .recipeModifier(HPSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("    WFFFW    ", "    WBBBW    ", "    WBBBW    ", "     BBB     ", "      B      ", "             ")
                    .slice("WFW FBBBF WFW", "WSW B###B WSW", "WBW B###B WBW", " B  B###B  B ", "     B#B     ", "     BBB     ")
                    .slice("FPPPPPPPPPPPF", "BPB B#P#B BPB", "BPB B#P#B BPB", "B B B#P#B B B", "    B#M#B    ", "     B#B     ")
                    .slice("WFW FBBBF WFW", "WBW B###B WBW", "WBW B###B WBW", " B  B###B  B ", "     B#B     ", "     BBB     ")
                    .slice("    WFFFW    ", "    WBCBW    ", "    WBBBW    ", "     BBB     ", "      B      ", "             ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('B', Predicates.blocks(EvoBlocks.HP_STEAM_MACHINE_CASING.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1)))
                    .where('F', Predicates.blocks(EvoBlocks.HP_STEAM_FIREBOX_CASING.get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('S', Predicates.abilities(PartAbility.STEAM).setExactLimit(2))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_wall")))))
                    .where('M', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(1))
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"), EvolutionCoreMod.id("block/machines/hp_steam_blast_furnace"))
            .langValue("Steam Boosted Blast Furnace")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_blast_furnace.h").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.STEEL.getId())
            .register();
}

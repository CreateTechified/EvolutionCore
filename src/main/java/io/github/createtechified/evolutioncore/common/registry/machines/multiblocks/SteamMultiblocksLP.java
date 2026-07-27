package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.steam.LPSteamParallelMultiblockMachine;
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
public class SteamMultiblocksLP {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition LP_STEAM_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("lp_steam_alloy_kiln", LPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifier(LPSteamParallelMultiblockMachine::recipeModifier, true)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" FFF ", " MMM ", " MMM ", " MMM ", "  M  ", "     ", "     ")
                    .slice("FMMMF", "MG#GM", "M###M", "M###M", " M#M ", " MMM ", " BBB ")
                    .slice("FMMMF", "M#P#M", "M#P#M", "M#P#M", "M#P#M", " MVM ", " B B ")
                    .slice("FMMMF", "MG#GM", "M###M", "M###M", " M#M ", " MMM ", " BBB ")
                    .slice(" FFF ", " MCM ", " MMM ", " MMM ", "  M  ", "     ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('M', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(30)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1).setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1).setMaxGlobalLimited(2)))
                    .where('P', Predicates.blocks(GTBlocks.CASING_BRONZE_PIPE.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('B', Predicates.blocks(GTBlocks.BRONZE_HULL.get()))
                    .where('V', Predicates.abilities(EvoMultiParts.STEAM_VENT))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), EvolutionCoreMod.id("block/machines/lp_steam_alloy_kiln"))
            .langValue("Low Pressure Steam Alloy Kiln")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_alloy_kiln.l").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.BRONZE.getId())
            .register();

    public static final MultiblockMachineDefinition LP_STEAM_GRINDER = Reference.REGISTRATE
            .multiblock("lp_steam_grinder", LPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.MACERATOR_RECIPES)
            .recipeModifier(LPSteamParallelMultiblockMachine::recipeModifier, true)
            .addOutputLimit(ItemRecipeCapability.CAP, 1)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("WBBBW", "WBVBW", "WBBBW")
                    .slice("BBBBB", "BG#GB", "B#F#B")
                    .slice("BBBBB", "B###B", "BFFFB")
                    .slice("BBBBB", "BG#GB", "B#F#B")
                    .slice("WBBBW", "WBCBW", "WBBBW")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where('B', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('G', Predicates.blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .where('F', Predicates.frames(GTMaterials.Bronze))
                    .where('V', Predicates.abilities(EvoMultiParts.STEAM_VENT))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_ochrum_wall")))))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), GTCEu.id("block/multiblock/steam_grinder"))
            .langValue("Low Pressure Steam Grinder")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_grinder.l").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.BRONZE.getId())
            .register();

    public static final MultiblockMachineDefinition LP_STEAM_OVEN = Reference.REGISTRATE
            .multiblock("lp_steam_oven", LPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.FURNACE_RECIPES)
            .recipeModifier(LPSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" FFF ", " W W ", " HHH ", "     ")
                    .slice("FBBBF", "WBBBW", "HBBBH", " VQV ")
                    .slice("FBBBF", " H#H ", "HBMBH", " Q#Q ")
                    .slice("FBBBF", "WBCBW", "HBBBH", " VQV ")
                    .slice(" FFF ", " W W ", " HHH ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('B', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()))
                    .where('H', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('M', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(1))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_ochrum_wall")))))
                    .where('V', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_ochrum_brick_wall")))))
                    .where('Q', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_ochrum_bricks")))))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), GTCEu.id("block/multiblock/steam_oven"))
            .langValue("Low Pressure Steam Oven")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_oven.l").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.BRONZE.getId())
            .register();

    public static final MultiblockMachineDefinition LP_STEAM_SEPARATOR = Reference.REGISTRATE
            .multiblock("lp_steam_separator", LPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.CENTRIFUGE_RECIPES)
            .recipeModifier(LPSteamParallelMultiblockMachine::recipeModifier, true)
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
                    .where('B', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_BRONZE_PIPE.get()))
                    .where('J', Predicates.blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .where('G', Predicates.blocks(AllPaletteBlocks.FRAMED_GLASS.get()))
                    .where('M', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(2))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_ochrum_wall")))))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), EvolutionCoreMod.id("block/machines/lp_steam_separator"))
            .langValue("Low Pressure Steam Separator")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_separator.l").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.BRONZE.getId())
            .register();

    public static final MultiblockMachineDefinition LP_STEAM_PURIFIER = Reference.REGISTRATE
            .multiblock("lp_steam_purifier", LPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .recipeType(GTRecipeTypes.ORE_WASHER_RECIPES)
            .recipeModifier(LPSteamParallelMultiblockMachine::recipeModifier, true)
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
                    .where('B', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()))
                    .where('H', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('P', Predicates.blocks(GTBlocks.CASING_BRONZE_PIPE.get()))
                    .where('S', Predicates.fluids(Fluids.WATER))
                    .where('G', Predicates.blocks(AllPaletteBlocks.FRAMED_GLASS.get()))
                    .where('V', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(1))
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_ochrum_wall")))))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), EvolutionCoreMod.id("block/machines/lp_steam_purifier"))
            .langValue("Low Pressure Steam Purifier")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_purifier.l").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.BRONZE.getId())
            .register();

    public static final MultiblockMachineDefinition LP_STEAM_ORE_FACTORY = Reference.REGISTRATE
            .multiblock("lp_steam_ore_factory", LPSteamParallelMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .recipeType(EvoRecipeTypes.STEAM_ORE_FACTORY)
            .recipeModifier(LPSteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  FFF  ", "  CCC  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice("FCCCCCF", "CG#P#GC", "V##P##V", "V##P##V", "V##P##V", "C##P##C", " V#P#V ", " C#P#C ", "  CMC  ", "  B B  ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("  FFF  ", "  C@C  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setExactLimit(2)))
                    .where('M', Predicates.abilities(EvoMultiParts.STEAM_VENT).setExactLimit(1))
                    .where('P', Predicates.blocks(GTBlocks.CASING_BRONZE_PIPE.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('V', Predicates.blocks(AllPaletteBlocks.FRAMED_GLASS.get()))
                    .where('B', Predicates.blocks(GTBlocks.BRONZE_HULL.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), EvolutionCoreMod.id("block/machines/ore_processing_factory"))
            .langValue("Low Pressure Steam Ore Factory")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_ore_factory.l").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.BRONZE.getId())
            .register();
}

package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.IBlockPattern;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FusionReactorMachine;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.FUSION_COIL;
import static com.gregtechceu.gtceu.common.data.GTBlocks.FUSION_GLASS;

public class FusionMultiblocks {
    public static void init() {
        FusionReactorMachine.registerFusionTier(UHV, " (Inertial MKI)");
        FusionReactorMachine.registerFusionTier(UEV, " (MKIV)");
        FusionReactorMachine.registerFusionTier(UIV, " (Inertial MKII)");
        FusionReactorMachine.registerFusionTier(UXV, " (MKV)");
    }

    private static Block getCasingState(int tier) {
        return switch (tier) {
            case UHV -> EvoBlocks.INERTIAL_FUSION_CASING.get();
            case UEV -> EvoBlocks.FUSION_CASING_MK4.get();
            case UIV -> EvoBlocks.INERTIAL_FUSION_CASING_MK2.get();
            default -> EvoBlocks.FUSION_CASING_MK5.get();
        };
    }

    private static net.minecraft.resources.ResourceLocation getCasingTexture(int tier) {
        return switch (tier) {
            case UHV -> io.github.createtechified.evolutioncore.EvolutionCoreMod.id("block/casings/fusion/inertial_fusion_casing");
            case UEV -> io.github.createtechified.evolutioncore.EvolutionCoreMod.id("block/casings/fusion/fusion_casing_mk4");
            case UIV -> io.github.createtechified.evolutioncore.EvolutionCoreMod.id("block/casings/fusion/inertial_fusion_casing_mk2");
            default -> io.github.createtechified.evolutioncore.EvolutionCoreMod.id("block/casings/fusion/fusion_casing_mk5");
        };
    }

    private static MultiblockMachineDefinition registerFusionReactor(String name, int tier, boolean inertial, String langName) {
        var builder = Reference.REGISTRATE.multiblock(name, holder -> new FusionReactorMachine(holder, tier))
                .rotationState(RotationState.ALL)
                .langValue(langName)
                .recipeType(GTRecipeTypes.FUSION_RECIPES)
                .tier(tier);

        if (inertial) {
            builder = builder.recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    FusionReactorMachine::recipeModifier, GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers.BATCH_MODE);
        } else {
            builder = builder.recipeModifiers(GTRecipeModifiers.DEFAULT_ENVIRONMENT_REQUIREMENT,
                    FusionReactorMachine::recipeModifier, GTRecipeModifiers.BATCH_MODE);
        }

        return builder
                .appearanceBlock(() -> getCasingState(tier))
                .model(GTMachineModels.createWorkableCasingMachineModel(getCasingTexture(tier),
                        GTCEu.id("block/multiblock/fusion_reactor")))
                .pattern(definition -> inertial
                        ? buildInertialPattern(definition, tier)
                        : buildGtPattern(definition, tier))
                .tooltips(Component.translatable("gtceu.machine.fusion_reactor.overclocking"))
                .hasBER(true)
                .register();
    }

    private static IBlockPattern buildGtPattern(MultiblockMachineDefinition definition, int tier) {
        var casing = Predicates.blocks(getCasingState(tier));
        var coil = Predicates.blocks(FUSION_COIL.get());
        var glass = Predicates.blocks(FUSION_GLASS.get()).or(casing);
        var energyHatch = Predicates.blocks(PartAbility.INPUT_ENERGY.getBlocks(tier).toArray(Block[]::new));
        return MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                .slice("               ", "      OGO      ", "               ")
                .slice("      ICI      ", "    GG###GG    ", "      ICI      ")
                .slice("    CC   CC    ", "   E##OGO##E   ", "    CC   CC    ")
                .slice("   C       C   ", "  EKEG   GEKE  ", "   C       C   ")
                .slice("  C         C  ", " G#E       E#G ", "  C         C  ")
                .slice("  C         C  ", " G#G       G#G ", "  C         C  ")
                .slice(" I           I ", "O#O         O#O", " I           I ")
                .slice(" C           C ", "G#G         G#G", " C           C ")
                .slice(" I           I ", "O#O         O#O", " I           I ")
                .slice("  C         C  ", " G#G       G#G ", "  C         C  ")
                .slice("  C         C  ", " G#E       E#G ", "  C         C  ")
                .slice("   C       C   ", "  EKEG   GEKE  ", "   C       C   ")
                .slice("    CC   CC    ", "   E##OGO##E   ", "    CC   CC    ")
                .slice("      ICI      ", "    GG###GG    ", "      ICI      ")
                .slice("               ", "      O@O      ", "               ")
                .where('@', Predicates.controller(definition))
                .where('G', glass)
                .where('E', energyHatch)
                .where('C', casing)
                .where('K', coil)
                .where('O', casing.or(Predicates.abilities(PartAbility.EXPORT_FLUIDS)))
                .where('#', Predicates.air())
                .where('I', casing.or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(2)))
                .where(' ', Predicates.any())
                .build();
    }

    private static IBlockPattern buildInertialPattern(MultiblockMachineDefinition definition, int tier) {
        var casing = Predicates.blocks(getCasingState(tier));
        var coil = Predicates.blocks(FUSION_COIL.get());
        var glass = Predicates.blocks(FUSION_GLASS.get()).or(casing);
        var energyHatch = Predicates.blocks(PartAbility.INPUT_ENERGY.getBlocks(tier).toArray(Block[]::new));
        var flexInput = casing.or(Predicates.abilities(PartAbility.IMPORT_FLUIDS));
        var flexOutput = casing.or(Predicates.abilities(PartAbility.EXPORT_FLUIDS));
        var parallelHatch = casing.or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1));

        return MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                .slice("                 ", "      oeeeo      ", "                 ")
                .slice("      bcccb      ", "    ee#####ee    ", "      bcccb      ")
                .slice("    cc  c  cc    ", "   g##oc#co##g   ", "    cc  c  cc    ")
                .slice("   c    c    c   ", "  ghge ehe eghg  ", "   c    c    c   ")
                .slice("  c     c     c  ", " e#g   ehe   g#e ", "  c     c     c  ")
                .slice("  c     c     c  ", " e#e   c#c   e#e ", "  c     c     c  ")
                .slice(" b     c c     b ", "o#o   e#c#e   o#o", " b     c c     b ")
                .slice(" c    c   c    c ", "e#ceec#e e#ceec#e", " c    c   c    c ")
                .slice(" ccccc     ccccc ", "e##hh#c   c#hh##e", " ccccc     ccccc ")
                .slice(" c    c   c    c ", "e#ceec#e e#ceec#e", " c    c   c    c ")
                .slice(" b     c c     b ", "o#o   e#c#e   o#o", " b     c c     b ")
                .slice("  c     c     c  ", " e#e   c#c   e#e ", "  c     c     c  ")
                .slice("  c     c     c  ", " e#g   ehe   g#e ", "  c     c     c  ")
                .slice("   c    c    c   ", "  ghge ehe eghg  ", "   c    c    c   ")
                .slice("    cc  c  cc    ", "   g##oc#co##g   ", "    cc  c  cc    ")
                .slice("      bcccb      ", "    ee#####ee    ", "      bcfcb      ")
                .slice("                 ", "      oc@co      ", "                 ")
                .where('@', Predicates.controller(definition))
                .where('#', Predicates.air())
                .where('b', flexInput)
                .where('c', casing)
                .where('e', glass)
                .where('f', parallelHatch)
                .where('g', energyHatch)
                .where('h', coil)
                .where('o', flexOutput)
                .where(' ', Predicates.any())
                .build();
    }

    public static final MultiblockMachineDefinition INERTIAL_FUSION_REACTOR_MK1 = registerFusionReactor(
            "inertial_fusion_reactor_mk1", UHV, true, "Inertial Fusion Reactor MK I");

    public static final MultiblockMachineDefinition FUSION_REACTOR_MK4 = registerFusionReactor(
            "fusion_reactor_mk4", UEV, false, "Fusion Reactor Computer MK IV");

    public static final MultiblockMachineDefinition INERTIAL_FUSION_REACTOR_MK2 = registerFusionReactor(
            "inertial_fusion_reactor_mk2", UIV, true, "Inertial Fusion Reactor MK II");

    public static final MultiblockMachineDefinition FUSION_REACTOR_MK5 = registerFusionReactor(
            "fusion_reactor_mk5", UXV, false, "Fusion Reactor Computer MK V");
}
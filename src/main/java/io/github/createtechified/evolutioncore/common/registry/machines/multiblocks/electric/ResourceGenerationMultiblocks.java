package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.simibubi.create.content.decoration.palettes.AllPaletteBlocks;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;

public class ResourceGenerationMultiblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition STEEL_GREENHOUSE = Reference.REGISTRATE
            .multiblock("steel_greenhouse", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .recipeType(EvoRecipeTypes.STEEL_GREENHOUSE)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" MMMMM ", " MHHHM ", "  MMM  ", "  GGG  ", "  GGG  ", "  GGG  ", "  GGG  ", "       ", "       ")
                    .slice("MMHHHMM", "MMMMMMM", " M   M ", " M   M ", " M   M ", " G   G ", " G   G ", "  GGG  ", "       ")
                    .slice("MHDDDHM", "HM   MH", "M     M", "G     G", "G     G", "G  L  G", "G     G", " G   G ", "  GGG  ")
                    .slice("MHDDDHM", "HM W MH", "M  W  M", "G  W  G", "G  W  G", "G LWL G", "G  L  G", " G   G ", "  GGG  ")
                    .slice("MHDDDHM", "HM   MH", "M     M", "G     G", "G     G", "G  L  G", "G     G", " G   G ", "  GGG  ")
                    .slice("MMHHHMM", "MMMMMMM", " M   M ", " M   M ", " M   M ", " G   G ", " G   G ", "  GGG  ", "       ")
                    .slice(" MMMMM ", " MHCHM ", "  MMM  ", "  GGG  ", "  GGG  ", "  GGG  ", "  GGG  ", "       ", "       ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('M', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where('G', Predicates.blocks(AllPaletteBlocks.FRAMED_GLASS.get()))
                    .where('L', Predicates.blocks(Blocks.OAK_LEAVES))
                    .where('W', Predicates.blocks(Blocks.OAK_LOG))
                    .where('D', Predicates.blocks(EvoBlocks.ORGANIC_PLANT_MATTER.get()))
                    .where('H', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                    )
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"), GTCEu.id("block/multiblock/implosion_compressor"))
            .langValue("Steel Greenhouse")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_greenhouse").withStyle(ChatFormatting.GRAY))
            .register();
}

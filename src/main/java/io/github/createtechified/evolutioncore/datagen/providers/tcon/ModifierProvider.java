package io.github.createtechified.evolutioncore.datagen.providers.tcon;

import io.github.createtechified.evolutioncore.common.integration.tcon.EvoModifiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierSlotModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.SlotType;

@MethodsReturnNonnullByDefault
public class ModifierProvider extends AbstractModifierProvider {
    public ModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public String getName() {
        return "EvolutionCore Modifiers";
    }

    @Override
    protected void addModifiers() {
        buildModifier(EvoModifiers.MATHEMATICAL_MODIFIER).tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS).levelDisplay(ModifierLevelDisplay.NO_LEVELS).priority(125);
        buildModifier(EvoModifiers.MODIFIABLE_MODIFIER).tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS).levelDisplay(ModifierLevelDisplay.NO_LEVELS).priority(125).addModule(ModifierSlotModule.slot(SlotType.UPGRADE).eachLevel(3));
    }
}

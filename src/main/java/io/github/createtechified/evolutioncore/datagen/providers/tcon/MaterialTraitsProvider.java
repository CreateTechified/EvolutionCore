package io.github.createtechified.evolutioncore.datagen.providers.tcon;

import io.github.createtechified.evolutioncore.common.integration.tcon.EvoMaterials;
import io.github.createtechified.evolutioncore.common.integration.tcon.EvoModifiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.tools.data.ModifierIds;

@MethodsReturnNonnullByDefault
public class MaterialTraitsProvider extends AbstractMaterialTraitDataProvider {
    public MaterialTraitsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    public String getName() {
        return "EvolutionCore Material Traits";
    }

    @Override
    protected void addMaterialTraits() {
        addTraits(EvoMaterials.UNSTABLE, MaterialRegistry.MELEE_HARVEST, new ModifierEntry(ModifierIds.reinforced, 5), new ModifierEntry(EvoModifiers.mathematical, 1));
        addTraits(EvoMaterials.MAGICAL_WOOD, MaterialRegistry.MELEE_HARVEST, new ModifierEntry(EvoModifiers.modifiable, 1));
    }
}

package io.github.createtechified.evolutioncore.datagen.providers.tcon;

import io.github.createtechified.evolutioncore.common.integration.tcon.EvoMaterials;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class MaterialDefinitionProvider extends AbstractMaterialDataProvider {
    public MaterialDefinitionProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public String getName() {
        return "EvolutionCore Material Definitions";
    }

    @Override
    protected void addMaterials() {
        addMaterial(EvoMaterials.UNSTABLE, 6, ORDER_NETHER, false);
        addMaterial(EvoMaterials.MAGICAL_WOOD, 0, ORDER_GENERAL, true);
    }
}

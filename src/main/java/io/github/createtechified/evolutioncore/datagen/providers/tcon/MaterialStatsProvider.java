package io.github.createtechified.evolutioncore.datagen.providers.tcon;

import io.github.createtechified.evolutioncore.common.integration.tcon.EvoMaterials;
import io.github.createtechified.evolutioncore.common.registry.ModToolTiers;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Tiers;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

public class MaterialStatsProvider extends AbstractMaterialStatsDataProvider {
    public MaterialStatsProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    public String getName() {
        return "EvolutionCore Material Stats";
    }

    @Override
    protected void addMaterialStats() {
        harvest();
    }

    private void harvest() {
        addMaterialStats(EvoMaterials.UNSTABLE, new HeadMaterialStats(75, 7f, ModToolTiers.UNSTABLE, 2f), HandleMaterialStats.multipliers().build(), StatlessMaterialStats.BINDING);
        addMaterialStats(EvoMaterials.MAGICAL_WOOD, new HeadMaterialStats(97, 1.5f, Tiers.WOOD, 1f), HandleMaterialStats.multipliers().build(), StatlessMaterialStats.BINDING);
    }
}

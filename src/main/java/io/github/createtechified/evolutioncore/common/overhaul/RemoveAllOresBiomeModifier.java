package io.github.createtechified.evolutioncore.common.overhaul;

import com.mojang.serialization.Codec;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record RemoveAllOresBiomeModifier(HolderSet<Biome> biomes) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.REMOVE && biomes.contains(biome)) {
            builder.getGenerationSettings()
                    .getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).clear();
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return EvolutionCoreMod.REMOVE_ALL_ORES.get();
    }
}

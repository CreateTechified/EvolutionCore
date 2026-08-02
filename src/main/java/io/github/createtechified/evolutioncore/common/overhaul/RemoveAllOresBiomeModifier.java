package io.github.createtechified.evolutioncore.common.overhaul;

import com.mojang.serialization.MapCodec;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import org.jetbrains.annotations.NotNull;

public record RemoveAllOresBiomeModifier(HolderSet<Biome> biomes) implements BiomeModifier {
    @Override
    public void modify(@NotNull Holder<Biome> biome, @NotNull Phase phase, ModifiableBiomeInfo.BiomeInfo.@NotNull Builder builder) {
        if (phase == Phase.REMOVE && biomes.contains(biome)) {
            builder.getGenerationSettings()
                    .getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).clear();
        }
    }

    @Override
    public @NotNull MapCodec<? extends BiomeModifier> codec() {
        return EvolutionCoreMod.REMOVE_ALL_ORES.get();
    }
}

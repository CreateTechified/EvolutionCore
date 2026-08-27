package io.github.createtechified.evolutioncore;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.createtechified.evolutioncore.common.overhaul.RemoveAllOresBiomeModifier;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.EvoElements;
import io.github.createtechified.evolutioncore.common.registry.EvoItems;
import io.github.createtechified.evolutioncore.common.registry.EvoMaterials;
import io.github.createtechified.evolutioncore.common.registry.EvoModifications;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoMachineLoader;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeInitializer;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeRemovals;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import io.github.createtechified.evolutioncore.datagen.EvoDatagen;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.function.Consumer;

@Mod(Reference.MODID)
public class EvolutionCoreMod {
    private static boolean didRunRegistration = false;
    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Reference.MODID);

    public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<RemoveAllOresBiomeModifier>> REMOVE_ALL_ORES =
            BIOME_MODIFIER_SERIALIZERS.register("remove_all_ores",
                    () -> RecordCodecBuilder.mapCodec(instance ->
                            instance.group(
                                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(RemoveAllOresBiomeModifier::biomes)
                            ).apply(instance, RemoveAllOresBiomeModifier::new)
                    )
            );

    public EvolutionCoreMod(IEventBus bus, ModContainer container) {
        bus.register(this);
        BIOME_MODIFIER_SERIALIZERS.register(bus);
        Reference.REGISTRATE.registerEventListeners(bus);
    }

    @SubscribeEvent
    public void onRegister(RegisterEvent event) {
        if (didRunRegistration) return;
        didRunRegistration = true;

        EvoTabs.init();
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
        EvoItems.init();
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_BLOCKS);
        EvoBlocks.init();
        EvoRecipeTypes.init();
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MACHINES);
        EvoMachineLoader.init();
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MATERIALS);
        EvoElements.init();
        EvoMaterials.init();

        EvoDatagen.registrateDatagen();
    }

    public static void addRecipes(RecipeOutput provider) {
        EvoRecipeInitializer.init(provider);
    }

    public static void removeRecipes(Consumer<ResourceLocation> provider) {
        EvoRecipeRemovals.init(provider);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MODID, path);
    }
}

package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.createtechified.evolutioncore.common.overhaul.RemoveAllOresBiomeModifier;
import io.github.createtechified.evolutioncore.common.registry.*;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoMachineLoader;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeInitializer;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeRemovals;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import io.github.createtechified.evolutioncore.datagen.EvoDatagen;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

@Mod(Reference.MODID)
@SuppressWarnings("removal") // I don't really care about future deprecation. Thanks, Gradle.
public class EvolutionCoreMod {
    private static final ResourceLocation TEMPLATE_LOCATION = new ResourceLocation(Reference.MODID, "");
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Reference.MODID);

    public static final RegistryObject<Codec<RemoveAllOresBiomeModifier>> REMOVE_ALL_ORES =
            BIOME_MODIFIER_SERIALIZERS.register("remove_all_ores",
                    () -> RecordCodecBuilder.<RemoveAllOresBiomeModifier>mapCodec(instance ->
                            instance.group(
                                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(RemoveAllOresBiomeModifier::biomes)
                            ).apply(instance, RemoveAllOresBiomeModifier::new)
                    ).codec()
            );

    public EvolutionCoreMod() {
        Reference.LOGGER.info("Loading EvolutionCore...");
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        eventBus.addGenericListener(Element.class, this::registerElements);
        eventBus.addListener(this::addMaterials);
        eventBus.addListener(this::modifyMaterials);
        BIOME_MODIFIER_SERIALIZERS.register(eventBus);
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
        EvoItems.init();
        EvoBlocks.init();
        EvoTabs.init();
        Reference.REGISTRATE.registerEventListeners(eventBus);
        EvoDatagen.init();
    }

    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EvoRecipeTypes.init();
    }

    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EvoMachineLoader.init();
    }

    public void registerElements(GTCEuAPI.RegisterEvent<ResourceLocation, Element> event) {
        EvoElements.init();
    }

    private void addMaterials(MaterialEvent event) {
        EvoMaterials.init();
    }

    private void modifyMaterials(PostMaterialEvent event) {
        EvoModifications.materials(event);
    }

    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        EvoRecipeInitializer.init(provider);
    }

    public static void removeRecipes(Consumer<ResourceLocation> provider) {
        EvoRecipeRemovals.init(provider);
    }

    public static ResourceLocation id(String path) {
        if (path.isBlank()) {
            return TEMPLATE_LOCATION;
        }

        int i = path.indexOf(':');
        if (i > 0) {
            return new ResourceLocation(path);
        } else if (i == 0) {
            path = path.substring(i + 1);
        }
        // only convert it to camel_case if it has any uppercase to begin with
        if (FormattingUtil.hasUpperCase(path)) {
            path = FormattingUtil.toLowerCaseUnderscore(path);
        }
        return TEMPLATE_LOCATION.withPath(path);
    }
}

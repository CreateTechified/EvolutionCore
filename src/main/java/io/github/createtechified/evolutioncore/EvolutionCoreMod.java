package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.createtechified.evolutioncore.common.overhaul.RemoveAllOresBiomeModifier;
import io.github.createtechified.evolutioncore.common.recipe.conditions.VacuumCondition;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;
import io.github.createtechified.evolutioncore.common.registry.ModItems;
import io.github.createtechified.evolutioncore.common.registry.ModMachines;
import io.github.createtechified.evolutioncore.common.registry.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Reference.MODID)
@SuppressWarnings("removal") // Fuck right off removal warning ITS FOR 1.20.6 YOU DINGUS
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

    public static RecipeConditionType<VacuumCondition> VACUUM;

    public EvolutionCoreMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        eventBus.addGenericListener(RecipeConditionType.class, this::registerConditions);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        BIOME_MODIFIER_SERIALIZERS.register(eventBus);
        ModItems.register(eventBus);
        CreativeTabs.register(eventBus);
        Reference.REGISTRATE.registerRegistrate();
    }

    public void registerConditions(GTCEuAPI.RegisterEvent<String, RecipeConditionType<?>> event) {
        VACUUM = GTRegistries.RECIPE_CONDITIONS.register("vacuum", //
                new RecipeConditionType<>(VacuumCondition::new, VacuumCondition.CODEC));
    }

    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        ModRecipeTypes.init();
    }

    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        ModMachines.init();
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

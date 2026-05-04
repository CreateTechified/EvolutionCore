package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.createtechified.evolutioncore.common.overhaul.RemoveAllOresBiomeModifier;
import io.github.createtechified.evolutioncore.common.recipe.conditions.VacuumCondition;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;
import io.github.createtechified.evolutioncore.common.registry.ModItems;
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
        eventBus.addGenericListener(RecipeConditionType.class, this::registerConditions);
        BIOME_MODIFIER_SERIALIZERS.register(eventBus);
        ModItems.register(eventBus);
        CreativeTabs.register(eventBus);
    }

    public void registerConditions(GTCEuAPI.RegisterEvent<String, RecipeConditionType<?>> event) {
        VACUUM = GTRegistries.RECIPE_CONDITIONS.register("vacuum", //
                new RecipeConditionType<>(VacuumCondition::new, VacuumCondition.CODEC));
    }
}

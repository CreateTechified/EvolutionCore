package io.github.createtechified.evolutioncore;

import io.github.createtechified.evolutioncore.registry.CreativeTabs;
import io.github.createtechified.evolutioncore.registry.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class EvolutionCoreMod {
    public EvolutionCoreMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Items.register(eventBus);
        CreativeTabs.register(eventBus);
    }
}

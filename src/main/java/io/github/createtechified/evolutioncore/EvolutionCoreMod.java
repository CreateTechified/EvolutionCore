package io.github.createtechified.evolutioncore;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class EvolutionCoreMod {
    public EvolutionCoreMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}

package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import io.github.createtechified.evolutioncore.common.registry.GTEvoRegistry;

@com.gregtechceu.gtceu.api.addon.GTAddon
public class EvolutionCoreAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return GTEvoRegistry.REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return "";
    }
}

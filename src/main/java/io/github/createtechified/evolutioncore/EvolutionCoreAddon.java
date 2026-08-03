package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

@GTAddon
public class EvolutionCoreAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return Reference.REGISTRATE;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return Reference.MODID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        EvolutionCoreMod.addRecipes(provider);
    }

    @Override
    public void removeRecipes(Consumer<ResourceLocation> provider) {
        EvolutionCoreMod.removeRecipes(provider);
    }

    @Override
    public boolean requiresHighTier() {return true;}
}

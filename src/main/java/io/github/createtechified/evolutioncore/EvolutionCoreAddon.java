package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import io.github.createtechified.evolutioncore.common.registry.recipes.ResourceGenerationRecipes;
import net.minecraft.data.recipes.RecipeOutput;

@GTAddon(Reference.MODID)
public class EvolutionCoreAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return Reference.REGISTRATE;
    }

    @Override
    public void gtInitComplete() {
        Reference.LOGGER.info("EvolutionCore GT Init Complete!");
    }

    @Override
    public void addRecipes(RecipeOutput provider) {
        EvoRecipeTypes.init();
        ResourceGenerationRecipes.init(provider);
    }
}

package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import io.github.createtechified.evolutioncore.common.registry.recipes.ModRecipeTypes;
import io.github.createtechified.evolutioncore.common.registry.recipes.RecipeInitializer;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@com.gregtechceu.gtceu.api.addon.GTAddon
public class EvolutionCoreAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return Reference.REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return Reference.MODID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        ModRecipeTypes.init();
        RecipeInitializer.init(provider);
    }
}

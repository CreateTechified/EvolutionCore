package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import io.github.createtechified.evolutioncore.common.data.machine.primitive.FueledPrimitiveMultiblockBase;

import javax.annotation.Nullable;

public class EvoRecipeModifiers {
    public static ModifierFunction primitiveFuel(MetaMachine machine, @Nullable GTRecipe recipe) {
        if (!(machine instanceof FueledPrimitiveMultiblockBase fuelMachine)) return ModifierFunction.NULL;
        if (!fuelMachine.hasFuel()) return ModifierFunction.NULL;
        return ModifierFunction.IDENTITY;
    }
}
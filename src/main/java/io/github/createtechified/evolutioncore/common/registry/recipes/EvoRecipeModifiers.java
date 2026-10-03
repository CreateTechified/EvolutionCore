package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.ingredient.EnergyStack;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import io.github.createtechified.evolutioncore.common.data.machine.electric.FixedHeatingCoilElectricMultiblock;
import io.github.createtechified.evolutioncore.common.data.machine.primitive.FueledPrimitiveMultiblockBase;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK;
import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK;
import static com.gregtechceu.gtceu.api.recipe.OverclockingLogic.getCoilEUtDiscount;

public class EvoRecipeModifiers {
    public static ModifierFunction primitiveFuel(MetaMachine machine, @Nullable GTRecipe recipe) {
        if (!(machine instanceof FueledPrimitiveMultiblockBase fuelMachine)) return ModifierFunction.NULL;
        if (!fuelMachine.hasFuel()) return ModifierFunction.NULL;
        return ModifierFunction.IDENTITY;
    }

    public static @NotNull ModifierFunction crackerOverclock(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof FixedHeatingCoilElectricMultiblock coilMachine)) {
            return RecipeModifier.nullWrongType(FixedHeatingCoilElectricMultiblock.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > coilMachine.getTier()) return ModifierFunction.NULL;

        var oc = OverclockingLogic.NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe,
                coilMachine.getOverclockVoltage());
        if (coilMachine.getCoilType().getTier() > 0) {
            var coilModifier = ModifierFunction.builder()
                    .eutMultiplier(1.0 - coilMachine.getCoilType().getTier() * 0.1)
                    .build();
            oc = oc.andThen(coilModifier);
        }
        return oc;
    }

    public static @NotNull ModifierFunction ebfOverclock(@NotNull MetaMachine machine, @NotNull GTRecipe recipe) {
        if (!(machine instanceof FixedHeatingCoilElectricMultiblock coilMachine)) {
            return RecipeModifier.nullWrongType(FixedHeatingCoilElectricMultiblock.class, machine);
        }

        int blastFurnaceTemperature = coilMachine.getCoilType().getCoilTemperature() +
                (100 * Math.max(0, coilMachine.getTier() - GTValues.MV));
        int recipeTemp = recipe.data.getInt("ebf_temp");
        if (!recipe.data.contains("ebf_temp") || recipeTemp > blastFurnaceTemperature) {
            return ModifierFunction.cancel(Component.translatable("gtceu.recipe_modifier.coil_temperature_too_low"));
        }

        if (RecipeHelper.getRecipeEUtTier(recipe) > coilMachine.getTier()) {
            return ModifierFunction.cancel(Component.translatable("gtceu.recipe_modifier.insufficient_voltage"));
        }

        var discount = ModifierFunction.builder()
                .eutMultiplier(getCoilEUtDiscount(recipeTemp, blastFurnaceTemperature))
                .build();

        OverclockingLogic logic = (p, v) -> OverclockingLogic.heatingCoilOC(p, v, recipeTemp, blastFurnaceTemperature);
        var oc = logic.getModifier(machine, recipe, coilMachine.getOverclockVoltage());

        return oc.compose(discount);
    }

    public static @NotNull ModifierFunction pyrolyseOvenOverclock(@NotNull MetaMachine machine,
                                                                  @NotNull GTRecipe recipe) {
        if (!(machine instanceof FixedHeatingCoilElectricMultiblock coilMachine)) {
            return RecipeModifier.nullWrongType(FixedHeatingCoilElectricMultiblock.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > coilMachine.getTier()) return ModifierFunction.NULL;

        int tier = coilMachine.getCoilType().getTier();
        double durationMultiplier = (tier == 0) ? (4.0 / 3.0) : (2.0 / (tier + 1)); // 75% speed with cupro coils
        var durationModifier = ModifierFunction.builder()
                .durationMultiplier(durationMultiplier)
                .build();

        var oc = NON_PERFECT_OVERCLOCK_SUBTICK.getModifier(machine, recipe, coilMachine.getOverclockVoltage());
        return durationModifier.andThen(oc);
    }

    public static @NotNull ModifierFunction multiSmelterParallel(@NotNull MetaMachine machine,
                                                                 @NotNull GTRecipe recipe) {
        if (!(machine instanceof FixedHeatingCoilElectricMultiblock coilMachine)) {
            return RecipeModifier.nullWrongType(FixedHeatingCoilElectricMultiblock.class, machine);
        }

        int maxParallel = 32 * coilMachine.getCoilType().getLevel();
        int parallels = ParallelLogic.getParallelAmount(machine, recipe, maxParallel);
        if (parallels == 0) return ModifierFunction.NULL;

        int duration = (int) (128 * 2.0 * parallels / maxParallel);
        long eut = (long) (4L * maxParallel / (8.0 * coilMachine.getCoilType().getEnergyDiscount()));
        ModifierFunction baseModifier = r -> {
            var copy = r.copy();
            EURecipeCapability.putEUContent(copy.tickInputs, new EnergyStack(Math.max(1, eut)));
            copy.duration = Math.max(1, duration);
            return copy;
        };

        GTRecipe copy = baseModifier.apply(recipe);
        var ocModifier = NON_PERFECT_OVERCLOCK.getModifier(machine, copy, coilMachine.getOverclockVoltage());
        var parallelModifier = ModifierFunction.builder()
                .modifyAllContents(ContentModifier.multiplier(parallels))
                .parallels(parallels)
                .build();

        return baseModifier.andThen(ocModifier).andThen(parallelModifier);
    }
}
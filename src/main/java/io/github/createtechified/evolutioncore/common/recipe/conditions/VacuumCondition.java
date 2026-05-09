package io.github.createtechified.evolutioncore.common.recipe.conditions;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.machines.utilities.IVacuumMachine;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VacuumCondition extends RecipeCondition<VacuumCondition> {
    public static final Codec<VacuumCondition> CODEC = RecordCodecBuilder.create(instance -> RecipeCondition.isReverse(instance)
            .and(Codec.INT.fieldOf("tier").forGetter(val -> val.tier)
            ).apply(instance, VacuumCondition::new));

    public int tier;

    public VacuumCondition(boolean isReverse, int tier) {
        this.isReverse = isReverse;
        this.tier = tier;
    }

    public VacuumCondition(int tier) {
        this(false, tier);
    }

    public VacuumCondition() {
        this(false, 0);
    }

    @Override
    public RecipeConditionType<VacuumCondition> getType() {
        return EvolutionCoreMod.VACUUM;
    }

    @Override
    public Component getTooltips() {
        return Component.translatable("evolutioncore.tooltip.vacuum_pump" + tier);
    }

    @Override
    protected boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        MetaMachine machine = recipeLogic.getMachine();
        if (machine instanceof MultiblockControllerMachine controllerMachine) {
            if (checkVacuumTier(controllerMachine.getParts())) {return true;}
        }
        for (Direction side : GTUtil.DIRECTIONS) {
            if (side.getAxis() != Direction.Axis.Y && checkNeighborVacuumTier(machine, side)) {return true;}
        }
        return false;
    }

    @Override
    public VacuumCondition createTemplate() {
        return new VacuumCondition(0);
    }

    private boolean checkVacuumTier(List<IMultiPart> parts) {
        for (IMultiPart part : parts) {
            if (part instanceof IVacuumMachine vacuumMachine && vacuumMachine.getVacuumTier() >= tier) {
                return true;
            }
        }
        return false;
    }

    private boolean checkNeighborVacuumTier(MetaMachine machine, Direction side) {
        if (machine.getLevel().getBlockEntity(machine.getPos().relative(side)) instanceof IVacuumMachine vacuumMachine) {
            return vacuumMachine.getVacuumTier() >= tier;
        }
        return false;
    }
}

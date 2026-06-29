package io.github.createtechified.evolutioncore.common.machine.steam;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExhaustVentMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

public class SteamMufflerPartMachine extends MultiblockPartMachine implements IExhaustVentMachine {
    @Persisted
    private boolean needsVenting;

    public SteamMufflerPartMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public @NotNull Direction getVentingDirection() {
        return getFrontFacing();
    }

    @Override
    public boolean isNeedsVenting() {
        return this.needsVenting;
    }

    @Override
    public void setNeedsVenting(boolean b) {
        this.needsVenting = b;
    }

    @Override
    public void markVentingComplete() {
        this.needsVenting = false;
    }

    @Override
    public float getVentingDamage() {
        return 9F;
    }

    @Override
    public boolean afterWorking(IWorkableMultiController ctl) {
        super.afterWorking(ctl);
        this.needsVenting = true;
        checkVenting();
        return true;
    }
}

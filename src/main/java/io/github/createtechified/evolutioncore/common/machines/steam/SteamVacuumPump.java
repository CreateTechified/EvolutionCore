package io.github.createtechified.evolutioncore.common.machines.steam;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import io.github.createtechified.evolutioncore.common.machines.utilities.IVacuumMachine;

public class SteamVacuumPump extends SimpleSteamMachine implements IVacuumMachine {
    @Persisted
    private int vacuumTier;
    private TickableSubscription tickSubs;

    public SteamVacuumPump(IMachineBlockEntity holder, boolean isHighPressure) {
        super(holder, isHighPressure); // On 8.0 release, switch MMBE to MetaMachine regular, should work fine.
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            tickSubs = subscribeServerTick(tickSubs, this::serverTick);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (tickSubs != null) {
            tickSubs.unsubscribe();
            tickSubs = null;
        }
    }

    @Override
    public void afterWorking() {
        super.afterWorking();
    }

    private void tick() {
        if (isHighPressure() && getRecipeLogic().getTotalContinuousRunningTime() > 1200) {
            vacuumTier = 2;
        } else if (getRecipeLogic().getTotalContinuousRunningTime() > (isHighPressure() ? 600 : 1200)) {
            vacuumTier = 1;
        } else {
            vacuumTier = 0;
        }
    }

    @Override
    public int getVacuumTier() {
        return this.vacuumTier;
    }
}

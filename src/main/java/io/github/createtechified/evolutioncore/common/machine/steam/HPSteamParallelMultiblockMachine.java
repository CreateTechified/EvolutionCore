package io.github.createtechified.evolutioncore.common.machine.steam;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import lombok.Getter;
import lombok.Setter;

public class HPSteamParallelMultiblockMachine extends SteamParallelMultiblockMachine {
    @Getter
    @Setter
    private int maxParallels = ConfigHolder.INSTANCE.machines.steamMultiParallelAmount * 4;

    public HPSteamParallelMultiblockMachine(IMachineBlockEntity holder, Object... args) {
        super(holder);
        if (args.length > 0 && args[0] instanceof Integer i) {
            this.maxParallels = i;
        }
    }
}

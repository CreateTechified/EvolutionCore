package io.github.createtechified.evolutioncore.mixin.gt;

import com.gregtechceu.gtceu.api.machine.MachineInstanceFactory;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.common.data.machines.GCYMMachines;
import io.github.createtechified.evolutioncore.common.data.machine.electric.FixedHeatingCoilElectricMultiblock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GCYMMachines.class)
public class GCYMMultiblockMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 12), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, FixedHeatingCoilElectricMultiblock, ?> ALLOY_BLAST_SMELTER(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 22), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, FixedHeatingCoilElectricMultiblock, ?> ROTARY_HEARTH_FURNACE(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
}

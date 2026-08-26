package io.github.createtechified.evolutioncore.mixin.gt;

import com.gregtechceu.gtceu.api.machine.MachineInstanceFactory;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import io.github.createtechified.evolutioncore.common.data.machine.electric.FixedHeatingCoilElectricMultiblock;
import io.github.createtechified.evolutioncore.common.data.machine.primitive.PrimitiveBlastFurnace;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GTMultiMachines.class)
public class BaseMultiblockMixin {
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 1), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, PrimitiveBlastFurnace, ?> PRIMITIVE_BLAST_FURNACE(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, PrimitiveBlastFurnace::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 2), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, FixedHeatingCoilElectricMultiblock, ?> ELECTRIC_BLAST_FURNACE(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 5), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, FixedHeatingCoilElectricMultiblock, ?> PYROLYSE_OVEN(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 6), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, FixedHeatingCoilElectricMultiblock, ?> MULTI_SMELTER(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/MultiblockMachineBuilder;", ordinal = 7), remap = false, require = 1)
    private static MultiblockMachineBuilder<MultiblockMachineDefinition, FixedHeatingCoilElectricMultiblock, ?> CRACKER(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
}

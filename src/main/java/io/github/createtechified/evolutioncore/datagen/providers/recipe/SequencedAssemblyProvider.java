package io.github.createtechified.evolutioncore.datagen.providers.recipe;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterialItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.fluids.transfer.FillingRecipe;
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe;
import com.simibubi.create.content.kinetics.press.PressingRecipe;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class SequencedAssemblyProvider extends SequencedAssemblyRecipeGen {
    GeneratedRecipe

    VACUUM_TUBE_BASE = create("vacuum_tube_base", b -> b.require(GTMaterialItems.MATERIAL_ITEMS.get(TagPrefix.plate, GTMaterials.Steel))
            .transitionTo(EvoItems.INCOMPLETE_VACUUM_TUBE_BASE)
            .addOutput(EvoItems.VACUUM_TUBE_BASE, 70)
            .addOutput(GTMaterialItems.MATERIAL_ITEMS.get(TagPrefix.plate, GTMaterials.Steel), 30)
            .loops(5)
            .addStep(CuttingRecipe::new, rb -> rb)),

    UNSEALED_VACUUM_TUBE = create("unsealed_vacuum_tube", b -> b.require(EvoItems.VACUUM_TUBE_BASE)
            .transitionTo(EvoItems.INCOMPLETE_UNSEALED_VACUUM_TUBE)
            .addOutput(EvoItems.UNSEALED_VACUUM_TUBE, 47)
            .addOutput(EvoItems.FAILED_VACUUM_TUBE_PARTS, 53)
            .addStep(FillingRecipe::new, rb -> rb.require(GTMaterials.Glue.asFluidIngredient(200)))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(EvoItems.CARBON_FILAMENT))
            .addStep(CuttingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(EvoItems.GRAPHITE_ELECTRODE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(EvoItems.GRAPHITE_ELECTRODE))
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(GTMaterialItems.MATERIAL_ITEMS.get(TagPrefix.wireFine, GTMaterials.RedAlloy)))
            .addStep(PressingRecipe::new, rb -> rb)
            .addStep(DeployerApplicationRecipe::new, rb -> rb.require(GTItems.GLASS_TUBE.get())));

    public SequencedAssemblyProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Reference.MODID);
    }
}
package io.github.createtechified.evolutioncore.datagen.providers.recipe;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterialItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.kinetics.saw.CuttingRecipe;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;

public class SequencedAssemblyProvider extends SequencedAssemblyRecipeGen {
    GeneratedRecipe

    VACUUM_TUBE_BASE = create("vacuum_tube_base", b -> b.require(GTMaterialItems.MATERIAL_ITEMS.get(TagPrefix.plate, GTMaterials.Steel))
            .transitionTo(EvoItems.INCOMPLETE_VACUUM_TUBE_BASE)
            .addOutput(new ItemStack(EvoItems.VACUUM_TUBE_BASE), 70)
            .addOutput(GTMaterialItems.MATERIAL_ITEMS.get(TagPrefix.plate, GTMaterials.Steel), 30)
            .loops(5)
            .addStep(CuttingRecipe::new, rb -> rb))

    ;

    public SequencedAssemblyProvider(PackOutput output) {
        super(output, Reference.MODID);
    }
}

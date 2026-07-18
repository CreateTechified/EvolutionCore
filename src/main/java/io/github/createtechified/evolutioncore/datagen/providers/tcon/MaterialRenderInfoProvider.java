package io.github.createtechified.evolutioncore.datagen.providers.tcon;

import io.github.createtechified.evolutioncore.common.integration.tcon.EvoMaterials;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

@MethodsReturnNonnullByDefault
public class MaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {
    public MaterialRenderInfoProvider(PackOutput packOutput, @Nullable AbstractMaterialSpriteProvider materialSprites, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, materialSprites, existingFileHelper);
    }

    @Override
    public String getName() {
        return "EvolutionCore Material Render Info";
    }

    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(EvoMaterials.MAGICAL_WOOD);
        buildRenderInfo(EvoMaterials.UNSTABLE);
    }
}

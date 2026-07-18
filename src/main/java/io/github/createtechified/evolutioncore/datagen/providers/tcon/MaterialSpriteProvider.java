package io.github.createtechified.evolutioncore.datagen.providers.tcon;

import io.github.createtechified.evolutioncore.common.integration.tcon.EvoMaterials;
import net.minecraft.MethodsReturnNonnullByDefault;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToSpriteTransformer;

@MethodsReturnNonnullByDefault
public class MaterialSpriteProvider extends AbstractMaterialSpriteProvider {
    @Override
    public String getName() {
        return "EvolutionCore Material Sprites";
    }

    @Override
    protected void addAllMaterials() {
        buildMaterial(EvoMaterials.MAGICAL_WOOD).meleeHarvest().fallbacks("wood").transformer(GreyToSpriteTransformer.builder()
                .addARGB(0,   0xFF3E2723)
                .addARGB(63,  0xFF5D4037)
                .addARGB(102, 0xFFD7CCC8)
                .addARGB(140, 0xFFF5F5DC)
                .addARGB(178, 0xFFE6C229)
                .addARGB(216, 0xFFFFD700)
                .addARGB(255, 0xFFFFF176)
                .build());
        buildMaterial(EvoMaterials.UNSTABLE).meleeHarvest().fallbacks("crystal").colorMapper(GreyToColorMapping.builder()
                .addABGR(0,   0xFF000000)
                .addABGR(63,  0xFFFFFFFF)
                .addABGR(102, 0xFFFFFFFF)
                .addABGR(140, 0x00000000)
                .addABGR(178, 0x00000000)
                .addABGR(216, 0x00000000)
                .addABGR(255, 0xFFFFFFFF)
                .build());
    }
}

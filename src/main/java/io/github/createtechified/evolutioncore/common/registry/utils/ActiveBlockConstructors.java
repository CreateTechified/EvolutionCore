package io.github.createtechified.evolutioncore.common.registry.utils;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.property.GTBlockStateProperties;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ModelFile;

@SuppressWarnings("removal")
public class ActiveBlockConstructors {
    public static BlockEntry<ActiveBlock> constructIntakeCasingBlock(String name, String type, String lang) {
        return BlockConstructors.constructBlock(name, EvolutionCoreMod.id("block/casings/" + type + "/intake"), ActiveBlock::new, b -> b
                .lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE).properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)));
    }

    // modified from astrocore by hazevista
    public record FireboxInfo(String name, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {}

    public static BlockEntry<ActiveBlock> constructFirebox(FireboxInfo info, String lang) {
        return Reference.REGISTRATE.block(info.name, ActiveBlock::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .addLayer(() -> RenderType::translucent)
                .blockstate((ctx, prov) -> {
                    ModelFile inactive = prov.models().cubeBottomTop(ctx.getName(), info.side, info.bottom, info.top);
                    ModelFile active = prov.models()
                            .withExistingParent(ctx.getName() + "_active",
                                    new ResourceLocation("gtceu", "block/fire_box_active"))
                            .texture("side", info.side).texture("bottom", info.bottom).texture("top", info.top);
                    prov.getVariantBuilder(ctx.getEntry())
                            .partialState().with(GTBlockStateProperties.ACTIVE, false).modelForState()
                            .modelFile(inactive).addModel()
                            .partialState().with(GTBlockStateProperties.ACTIVE, true).modelForState().modelFile(active)
                            .addModel();
                })
                .lang(lang)
                .tag(CustomTags.MINEABLE_WITH_WRENCH, BlockTags.MINEABLE_WITH_PICKAXE)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .item(BlockItem::new).build().register();
    }
}

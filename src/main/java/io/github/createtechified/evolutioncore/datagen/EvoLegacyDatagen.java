package io.github.createtechified.evolutioncore.datagen;

import io.github.createtechified.evolutioncore.datagen.providers.tcon.MaterialDefinitionProvider;
import io.github.createtechified.evolutioncore.datagen.providers.tcon.MaterialRenderInfoProvider;
import io.github.createtechified.evolutioncore.datagen.providers.tcon.MaterialSpriteProvider;
import io.github.createtechified.evolutioncore.datagen.providers.tcon.MaterialStatsProvider;
import io.github.createtechified.evolutioncore.datagen.providers.tcon.MaterialTraitsProvider;
import io.github.createtechified.evolutioncore.datagen.providers.tcon.ModifierProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EvoLegacyDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput out = gen.getPackOutput();
        ExistingFileHelper efh = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        TinkerPartSpriteProvider partspr = new TinkerPartSpriteProvider();
        MaterialDefinitionProvider matdef = new MaterialDefinitionProvider(out);
        MaterialSpriteProvider sprpv = new MaterialSpriteProvider();
        boolean s = event.includeServer();
        boolean c = event.includeClient();
        gen.addProvider(s, matdef);
        gen.addProvider(s, new MaterialStatsProvider(out, matdef));
        gen.addProvider(s, new MaterialTraitsProvider(out, matdef));
        gen.addProvider(s, new ModifierProvider(out));
        gen.addProvider(c, new MaterialRenderInfoProvider(out, sprpv, efh));
        gen.addProvider(c, new MaterialPartTextureGenerator(out, efh, partspr, sprpv));
    }
}

package minneo.sparkmod;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.screen.HeavyWorkbenchScreen;
import minneo.sparkmod.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class SparkModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_PHOSPHORUS_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_PHOSPHORUS_SAPLING, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.HEAVY_WORKBENCH_SCREEN_HANDLER, HeavyWorkbenchScreen::new);
    }
}

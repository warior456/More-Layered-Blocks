package ugi.more_layered_blocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import ugi.more_layered_blocks.block.ModBlocks;

public class MoreLayeredBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
/*		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {if (world == null || pos == null) {
			return GrassColors.getDefaultColor();
		}
			return BiomeColors.getGrassColor(world, pos);}, ModBlocks.LAYERED_GRASS_BLOCK);
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAYERED_GRASS_BLOCK, RenderLayer.getCutoutMipped());

		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getDefaultColor(), ModBlocks.LAYERED_GRASS_BLOCK.asItem());
	*/}
}
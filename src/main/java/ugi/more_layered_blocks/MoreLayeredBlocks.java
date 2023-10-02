package ugi.more_layered_blocks;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ugi.more_layered_blocks.block.ModBlocks;
import ugi.more_layered_blocks.item.ModItemGroup;
import ugi.more_layered_blocks.item.ModItems;

public class MoreLayeredBlocks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("more_layered_blocks");

	public static final String MOD_ID = "more_layered_blocks";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroup.registerItemgroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		LOGGER.info("Hello Fabric world!");
	}
}
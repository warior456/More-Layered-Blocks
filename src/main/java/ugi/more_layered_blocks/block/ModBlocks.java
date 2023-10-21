package ugi.more_layered_blocks.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import ugi.more_layered_blocks.MoreLayeredBlocks;
import ugi.more_layered_blocks.block.layeredblocks.LayeredDirtBlock;
import ugi.more_layered_blocks.block.layeredblocks.LayeredGravelBlock;
import ugi.more_layered_blocks.block.layeredblocks.LayeredSandBlock;
import ugi.more_layered_blocks.item.ModItemGroup;

public class ModBlocks {

    public static final Block LAYERED_SAND = registerBlock("layered_sand",
            new LayeredSandBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND).notSolid().ticksRandomly()
                    .blockVision((state, world, pos) -> {return (Integer)state.get(SnowBlock.LAYERS) >= 8;})
                    .pistonBehavior(PistonBehavior.DESTROY)), ModItemGroup.MORE_LAYERED_BLOCKS);

    public static final Block LAYERED_RED_SAND = registerBlock("layered_red_sand",
            new LayeredSandBlock(FabricBlockSettings.create().mapColor(MapColor.ORANGE).instrument(Instrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND).notSolid().ticksRandomly()
                    .blockVision((state, world, pos) -> {return (Integer)state.get(SnowBlock.LAYERS) >= 8;})
                    .pistonBehavior(PistonBehavior.DESTROY)), ModItemGroup.MORE_LAYERED_BLOCKS);
    public static final Block LAYERED_GRAVEL = registerBlock("layered_gravel",
            new LayeredGravelBlock(FabricBlockSettings.create().mapColor(MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL).notSolid().ticksRandomly()
                    .blockVision((state, world, pos) -> {return (Integer)state.get(SnowBlock.LAYERS) >= 8;})
                    .pistonBehavior(PistonBehavior.DESTROY)), ModItemGroup.MORE_LAYERED_BLOCKS);

/*    public static final Block LAYERED_GRASS_BLOCK = registerBlock("layered_grass_block",
            new LayeredDirtBlock(FabricBlockSettings.create().mapColor(MapColor.PALE_GREEN).strength(0.6F).sounds(BlockSoundGroup.GRASS).notSolid().ticksRandomly()
                    .blockVision((state, world, pos) -> {return (Integer)state.get(SnowBlock.LAYERS) >= 8;})
                    .pistonBehavior(PistonBehavior.DESTROY)), ModItemGroup.MORE_LAYERED_BLOCKS);*/

    public static final Block LAYERED_DIRT = registerBlock("layered_dirt",
            new LayeredDirtBlock(FabricBlockSettings.create().mapColor(MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.GRAVEL).notSolid().ticksRandomly()
                    .blockVision((state, world, pos) -> {return (Integer)state.get(SnowBlock.LAYERS) >= 8;})
                    .pistonBehavior(PistonBehavior.DESTROY)), ModItemGroup.MORE_LAYERED_BLOCKS);



    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(MoreLayeredBlocks.MOD_ID, name), block);
    }


    private static Block registerBlockWithoutBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        return Registry.register(Registries.BLOCK, new Identifier(MoreLayeredBlocks.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {

        Item item = Registry.register(Registries.ITEM, new Identifier(MoreLayeredBlocks.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {

    }
}
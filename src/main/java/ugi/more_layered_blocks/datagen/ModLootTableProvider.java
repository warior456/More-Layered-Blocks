package ugi.more_layered_blocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.Properties;
import ugi.more_layered_blocks.block.ModBlocks;
import ugi.more_layered_blocks.block.layeredblocks.LayeredDirtBlock;
import ugi.more_layered_blocks.block.layeredblocks.LayeredGravelBlock;
import ugi.more_layered_blocks.block.layeredblocks.LayeredSandBlock;
import ugi.more_layered_blocks.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LAYERED_DIRT, (block) -> {
            return LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(LayeredDirtBlock.LAYERS.getValues(), (integer) -> {
                return ((LeafEntry.Builder<?>) ItemEntry.builder(ModItems.DIRT_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredDirtBlock.LAYERS, integer)))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer + (float) integer /2)));
            }).conditionally(WITHOUT_SILK_TOUCH), AlternativeEntry.builder(LayeredDirtBlock.LAYERS.getValues() , (integer) -> {
                return ItemEntry.builder(ModBlocks.LAYERED_DIRT).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer/2 ))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredDirtBlock.LAYERS, integer )));
            }))));
        });

/*        addDrop(ModBlocks.LAYERED_GRASS_BLOCK, (block) -> {
            return LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(LayeredDirtBlock.LAYERS.getValues(), (integer) -> {
                return ((LeafEntry.Builder<?>) ItemEntry.builder(ModItems.DIRT_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredDirtBlock.LAYERS, integer)))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer + (float) integer /2)));
            }).conditionally(WITHOUT_SILK_TOUCH), AlternativeEntry.builder(LayeredDirtBlock.LAYERS.getValues() , (integer) -> {
                return ItemEntry.builder(ModBlocks.LAYERED_GRASS_BLOCK).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer/2 ))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredDirtBlock.LAYERS, integer )));
            }))));
        });*/

        addDrop(ModBlocks.LAYERED_SAND, (block) -> {
            return LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(LayeredSandBlock.LAYERS.getValues(), (integer) -> {
                return ((LeafEntry.Builder<?>) ItemEntry.builder(ModItems.SAND_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredSandBlock.LAYERS, integer)))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer)));
            }).conditionally(WITHOUT_SILK_TOUCH), AlternativeEntry.builder(LayeredSandBlock.LAYERS.getValues() , (integer) -> {
                return ItemEntry.builder(ModBlocks.LAYERED_SAND).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer ))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredSandBlock.LAYERS, integer )));
            }))));
        });

        addDrop(ModBlocks.LAYERED_RED_SAND, (block) -> {
            return LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(LayeredSandBlock.LAYERS.getValues(), (integer) -> {
                return ((LeafEntry.Builder<?>) ItemEntry.builder(ModItems.RED_SAND_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredSandBlock.LAYERS, integer)))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer)));
            }).conditionally(WITHOUT_SILK_TOUCH), AlternativeEntry.builder(LayeredSandBlock.LAYERS.getValues() , (integer) -> {
                return ItemEntry.builder(ModBlocks.LAYERED_RED_SAND).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer ))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredSandBlock.LAYERS, integer )));
            }))));
        });

        addDrop(ModBlocks.LAYERED_GRAVEL, (block) -> {
            return LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(LayeredGravelBlock.LAYERS.getValues(), (integer) -> {
                return ((LeafEntry.Builder<?>) ItemEntry.builder(ModItems.GRAVEL_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredGravelBlock.LAYERS, integer)))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer)));
            }).conditionally(WITHOUT_SILK_TOUCH), AlternativeEntry.builder(LayeredGravelBlock.LAYERS.getValues() , (integer) -> {
                return ItemEntry.builder(ModBlocks.LAYERED_GRAVEL).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create((float) integer ))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(LayeredGravelBlock.LAYERS, integer )));
            }))));
        });
    }


    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
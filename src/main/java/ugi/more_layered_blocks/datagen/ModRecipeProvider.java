package ugi.more_layered_blocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import ugi.more_layered_blocks.block.ModBlocks;
import ugi.more_layered_blocks.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    //examples:
    ////https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-1.20.X/blob/a1ce57390adb5ef0f1cd6ba7a0bf6b1b659074f5/src/main/java/net/kaupenjoe/tutorialmod/datagen/ModRecipeProvider.java
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_DIRT.asItem(), 1)
                .pattern("###")
                .input('#', ModItems.DIRT_PILE)
                .criterion(hasItem(ModItems.DIRT_PILE), conditionsFromItem(ModItems.DIRT_PILE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_DIRT) + "_from_pile"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_SAND.asItem(), 2)
                .pattern("###")
                .input('#', ModItems.SAND_PILE)
                .criterion(hasItem(ModItems.SAND_PILE), conditionsFromItem(ModItems.SAND_PILE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_SAND) + "_from_pile"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_RED_SAND.asItem(), 2)
                .pattern("###")
                .input('#', ModItems.RED_SAND_PILE)
                .criterion(hasItem(ModItems.RED_SAND_PILE), conditionsFromItem(ModItems.RED_SAND_PILE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_RED_SAND) + "_from_pile"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_GRAVEL.asItem(), 2)
                .pattern("###")
                .input('#', ModItems.GRAVEL_PILE)
                .criterion(hasItem(ModItems.GRAVEL_PILE), conditionsFromItem(ModItems.GRAVEL_PILE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_GRAVEL) + "_from_pile"));

        //snowlike
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_DIRT.asItem(), 9)
                .pattern("###")
                .input('#', Blocks.DIRT)
                .criterion(hasItem(Blocks.DIRT), conditionsFromItem(Blocks.DIRT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_DIRT)));

/*        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_GRASS_BLOCK.asItem(), 9)
                .pattern("###")
                .input('#', Blocks.GRASS_BLOCK)
                .criterion(hasItem(Blocks.GRASS_BLOCK), conditionsFromItem(Blocks.GRASS_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_GRASS_BLOCK)));*/

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_SAND.asItem(), 18)
                .pattern("###")
                .input('#', Blocks.SAND)
                .criterion(hasItem(Blocks.SAND), conditionsFromItem(Blocks.SAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_SAND)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_RED_SAND.asItem(), 18)
                .pattern("###")
                .input('#', Blocks.RED_SAND)
                .criterion(hasItem(Blocks.RED_SAND), conditionsFromItem(Blocks.RED_SAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_RED_SAND)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAYERED_GRAVEL.asItem(), 18)
                .pattern("###")
                .input('#', Blocks.GRAVEL)
                .criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LAYERED_GRAVEL)));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DIRT_PILE, RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SAND_PILE, RecipeCategory.BUILDING_BLOCKS, Blocks.SAND);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RED_SAND_PILE, RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SAND);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GRAVEL_PILE, RecipeCategory.BUILDING_BLOCKS, Blocks.GRAVEL);
    }
}
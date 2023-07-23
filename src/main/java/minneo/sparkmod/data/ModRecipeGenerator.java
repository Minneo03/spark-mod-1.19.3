package minneo.sparkmod.data;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //---------------------------All Base Minium Recipes
        //All smelting recipes
        offerSmelting(exporter, List.of(ModItems.RAW_MINIUM), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 200, "spark");
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 200, "spark");
        offerSmelting(exporter, List.of(ModBlocks.MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 200, "spark");

        //All blasting recipes
        offerBlasting(exporter, List.of(ModItems.RAW_MINIUM), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 100, "spark");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 100, "spark");
        offerBlasting(exporter, List.of(ModBlocks.MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 100, "spark");

        //Creates both a recipe for making a minium block from 9 minium and the reverse.
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MINIUM, RecipeCategory.MISC, ModBlocks.MINIUM_BLOCK);

        //I'm going to keep this for now - Creates a Raw Minium from 8 Stone and 1 Minium
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_MINIUM)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('M', ModItems.MINIUM)
                .criterion(FabricRecipeProvider.hasItem(Items.STONE),
                        FabricRecipeProvider.conditionsFromItem(Items.STONE))
                .criterion(FabricRecipeProvider.hasItem(ModItems.MINIUM),
                        FabricRecipeProvider.conditionsFromItem(ModItems.MINIUM))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.RAW_MINIUM)));

        //----------------------------All Base White Phosphorus Recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_PHOSPHORUS_PLANKS, 4)
                .input(ModBlocks.WHITE_PHOSPHORUS_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.WHITE_PHOSPHORUS_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.WHITE_PHOSPHORUS_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.WHITE_PHOSPHORUS_PLANKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WHITE_PHOSPHORUS_WOOD, 3)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.WHITE_PHOSPHORUS_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.WHITE_PHOSPHORUS_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.WHITE_PHOSPHORUS_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.WHITE_PHOSPHORUS_WOOD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD, 3)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD)));

    }
}

package minneo.sparkmod.data;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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
        offerSmelting(exporter, List.of(ModItems.RAW_MINIUM), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 200, "spark");
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 200, "spark");
        offerSmelting(exporter, List.of(ModBlocks.MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 200, "spark");
        offerBlasting(exporter, List.of(ModItems.RAW_MINIUM), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 100, "spark");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 100, "spark");
        offerBlasting(exporter, List.of(ModBlocks.MINIUM_ORE), RecipeCategory.MISC, ModItems.MINIUM, 0.7f, 100, "spark");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MINIUM, RecipeCategory.MISC, ModBlocks.MINIUM_BLOCK);

        //Just an example
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
    }
}

package minneo.sparkmod.data;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    //BlockStateModels
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Minium Models
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_MINIUM_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MINIUM_ORE);

        //White Phosphorus Models
        blockStateModelGenerator.registerLog(ModBlocks.WHITE_PHOSPHORUS_LOG).log(ModBlocks.WHITE_PHOSPHORUS_LOG).wood(ModBlocks.WHITE_PHOSPHORUS_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG).log(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG).wood(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WHITE_PHOSPHORUS_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WHITE_PHOSPHORUS_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.WHITE_PHOSPHORUS_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    //ItemModels
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MINIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MINIUM, Models.GENERATED);
    }
}

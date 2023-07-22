package minneo.sparkmod.data;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider{
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //Normal Blocks
        addDrop(ModBlocks.MINIUM_BLOCK);
        addDrop(ModBlocks.WHITE_PHOSPHORUS_LOG);
        addDrop(ModBlocks.WHITE_PHOSPHORUS_PLANKS);


        //Normal Ores
        addDrop(ModBlocks.MINIUM_ORE,oreDrops(ModBlocks.MINIUM_ORE, ModItems.RAW_MINIUM));
        addDrop(ModBlocks.DEEPSLATE_MINIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_MINIUM_ORE, ModItems.RAW_MINIUM));

    }
}

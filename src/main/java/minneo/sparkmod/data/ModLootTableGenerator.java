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
        //--Normal Blocks

        //Minium
        addDrop(ModBlocks.MINIUM_BLOCK);

        //White Phosphorus
        addDrop(ModBlocks.WHITE_PHOSPHORUS_LOG);
        addDrop(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG);
        addDrop(ModBlocks.WHITE_PHOSPHORUS_WOOD);
        addDrop(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD);
        addDrop(ModBlocks.WHITE_PHOSPHORUS_PLANKS);


        //--Normal Ores

        //Minium
        addDrop(ModBlocks.MINIUM_ORE,oreDrops(ModBlocks.MINIUM_ORE, ModItems.RAW_MINIUM));
        addDrop(ModBlocks.DEEPSLATE_MINIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_MINIUM_ORE, ModItems.RAW_MINIUM));

    }
}

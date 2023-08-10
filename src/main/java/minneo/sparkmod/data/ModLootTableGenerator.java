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
        addDrop(ModBlocks.HEAVY_WORKBENCH);
        addDrop(ModBlocks.STONE_BRICK_FORGE);

        //Mod Ore Blocks
        addDrop(ModBlocks.MINIUM_BLOCK);
        addDrop(ModBlocks.TUNGSTEN_BLOCK);

        //White Phosphorus
        addDrop(ModBlocks.WHITE_PHOSPHORUS_LOG);
        addDrop(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG);
        addDrop(ModBlocks.WHITE_PHOSPHORUS_WOOD);
        addDrop(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD);
        addDrop(ModBlocks.WHITE_PHOSPHORUS_PLANKS);

        //Mod Ores
        addDrop(ModBlocks.MINIUM_ORE,oreDrops(ModBlocks.MINIUM_ORE, ModItems.RAW_MINIUM));
        addDrop(ModBlocks.DEEPSLATE_MINIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_MINIUM_ORE, ModItems.RAW_MINIUM));
        addDrop(ModBlocks.TUNGSTEN_ORE,oreDrops(ModBlocks.TUNGSTEN_ORE, ModItems.RAW_TUNGSTEN));
        addDrop(ModBlocks.DEEPSLATE_TUNGSTEN_ORE,oreDrops(ModBlocks.DEEPSLATE_TUNGSTEN_ORE, ModItems.RAW_TUNGSTEN));

    }
}

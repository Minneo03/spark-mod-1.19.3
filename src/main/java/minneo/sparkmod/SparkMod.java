package minneo.sparkmod;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.item.ModItemGroup;
import minneo.sparkmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparkMod implements ModInitializer {
	public static final String MOD_ID = "spark-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("spark-mod");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}
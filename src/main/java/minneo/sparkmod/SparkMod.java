package minneo.sparkmod;

import minneo.sparkmod.block.ModBlocks;
import minneo.sparkmod.block.ModFlammableBlockRegistry;
import minneo.sparkmod.block.ModStrippableBlockRegistry;
import minneo.sparkmod.block.entity.ModBlockEntities;
import minneo.sparkmod.item.ModItemGroup;
import minneo.sparkmod.item.ModItems;
import minneo.sparkmod.screen.ModScreenHandlers;
import minneo.sparkmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for initializing the mod. The onInitialize method will basically "boot up" this mod.
 */
public class SparkMod implements ModInitializer {
	public static final String MOD_ID = "spark-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("spark-mod");

	/**
	 * This is the "main method" of this mod. What will be initialized the second you boot up this mod? Here it is. Most if not all method calls will be static to keep this method clean and easily readable.
	 */
	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		ModStrippableBlockRegistry.registerStrippableBlocks();
	}
}
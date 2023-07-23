package minneo.sparkmod.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

/**
 * This class has the sole purpose of cleaning up the onInitialize method of the SparkMod class. Basically keeping the main method clean.
 */
public class ModStrippableBlockRegistry {

    /**
     * This method is static so the main method can call it without using a constructor, this method will register all possible strippable blocks in this mod.
     */
    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(ModBlocks.WHITE_PHOSPHORUS_LOG, ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG);
        StrippableBlockRegistry.register(ModBlocks.WHITE_PHOSPHORUS_WOOD, ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD);

    }
}

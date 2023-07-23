package minneo.sparkmod.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

/**
 * This class has the sole purpose of keeping the onInitialize method of the SparkMod class clean.
 */
public class ModFlammableBlockRegistry {
    /**
     * Static as to skip the need for a constructor in the "main method" that is the onInitialize method.
     */
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.WHITE_PHOSPHORUS_LOG, 8, 8);
        registry.add(ModBlocks.WHITE_PHOSPHORUS_LOG, 8, 8);
        registry.add(ModBlocks.WHITE_PHOSPHORUS_LOG, 8, 8);
        registry.add(ModBlocks.WHITE_PHOSPHORUS_LOG, 8, 8);

        registry.add(ModBlocks.WHITE_PHOSPHORUS_PLANKS, 8, 32);
        registry.add(ModBlocks.WHITE_PHOSPHORUS_LEAVES, 45, 90);
    }
}

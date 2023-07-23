package minneo.sparkmod.world;

import minneo.sparkmod.SparkMod;
import minneo.sparkmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

/**
 * For ModConfiguredFeatures. This one I did copy from '<a href="https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-1.19.3/blob/7-treeGen/src/main/java/net/kaupenjoe/tutorialmod/world/ModConfiguredFeatures.java">...</a>'. Then I modified some of it to fit my needs.
 */
public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_PHOSPHORUS_KEY = registerKey("white_phosphorus");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        //This is going to register this "Tree" to this particular "Key" which will be referenced in the WhitePhosphorusSaplingGenerator Class.
        register(context, WHITE_PHOSPHORUS_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.WHITE_PHOSPHORUS_LOG),
                new DarkOakTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.WHITE_PHOSPHORUS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1,0,2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SparkMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

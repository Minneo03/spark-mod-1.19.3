package minneo.sparkmod.block;

import minneo.sparkmod.SparkMod;
import minneo.sparkmod.block.custom.BrickForgeBlock;
import minneo.sparkmod.item.ModItemGroup;
import minneo.sparkmod.world.tree.WhitePhosphorusSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

/**
 * This class is what initializes blocks as final variables, though it will primarily use the ModModelProvider to generate json's which allow the blocks in minecraft to take form and work as they do in the base game.
 */
public class ModBlocks {
    //Minium Block Group
    public static final Block MINIUM_BLOCK = registerBlock("minium_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4.0f).requiresTool()));
    public static final Block MINIUM_ORE = registerBlock("minium_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4.0f).requiresTool(), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_MINIUM_ORE = registerBlock("deepslate_minium_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4.0f).requiresTool(), UniformIntProvider.create(2, 5)));

    //White Phosphorus Block Group
    public static final Block WHITE_PHOSPHORUS_LOG = registerBlock("white_phosphorus_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(5.0f).requiresTool()));
    public static final Block WHITE_PHOSPHORUS_WOOD = registerBlock("white_phosphorus_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(5.0f).requiresTool()));
    public static final Block STRIPPED_WHITE_PHOSPHORUS_LOG = registerBlock("stripped_white_phosphorus_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(5.0f).requiresTool()));
    public static final Block STRIPPED_WHITE_PHOSPHORUS_WOOD = registerBlock("stripped_white_phosphorus_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(5.0f).requiresTool()));

    public static final Block WHITE_PHOSPHORUS_PLANKS = registerBlock("white_phosphorus_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(5.0f).requiresTool()));
    public static final Block WHITE_PHOSPHORUS_LEAVES = registerBlock("white_phosphorus_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(0.5f)));

    public static final Block WHITE_PHOSPHORUS_SAPLING = registerBlock("white_phosphorus_sapling", new SaplingBlock(new WhitePhosphorusSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(0.5f)));

    //Custom Blocks
    public static final Block BRICK_FORGE = registerBlock("brick_forge",
            new BrickForgeBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5.0f).requiresTool().nonOpaque()));

    /**
     * To register the block in the form that minecraft requires, I use this method. This method will also call registerBlockItem in order to register the block as an item in minecraft.
     * @param name - Name of the block in all lowercase with underscores instead of spaces.
     * @param block - A block object, which will generally have "new Block(parameters)" in its place.
     * @return - The block that has been created.
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SparkMod.MOD_ID, name), block);
    }

    /**
     * This method will register an item coinciding with the block being created.
     * @param name
     * @param block
     * @return - The item that has been created.
     */
    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SparkMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    /**
     * This method is just for logging purposes.
     */
    public static void registerModBlocks() {
        SparkMod.LOGGER.info("Registering ModBlocks for " + SparkMod.MOD_ID);
    }
}

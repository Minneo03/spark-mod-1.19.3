package minneo.sparkmod.item;

import minneo.sparkmod.SparkMod;
import minneo.sparkmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * This class is pretty much just used to add all the items from this mod into the "Spark" Item tab in creative mode.
 */
public class ModItemGroup {
    public static ItemGroup SPARK = Registry.register(Registries.ITEM_GROUP, new Identifier(SparkMod.MOD_ID, "spark"),
            FabricItemGroup.builder()
                    .displayName(Text.literal("Spark Mod"))
                    .icon(() -> new ItemStack(ModItems.MINIUM)).entries((displayContext, entries) -> {
                        //Ore Items
                        entries.add(ModItems.MINIUM);
                        entries.add(ModItems.RAW_MINIUM);
                        entries.add(ModItems.TUNGSTEN);
                        entries.add(ModItems.RAW_TUNGSTEN);

                        //Ore Blocks
                        entries.add(ModBlocks.MINIUM_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_MINIUM_ORE);
                        entries.add(ModBlocks.MINIUM_ORE);
                        entries.add(ModBlocks.TUNGSTEN_BLOCK);
                        entries.add(ModBlocks.TUNGSTEN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);

                        //Wood Blocks
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_LOG);
                        entries.add(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG);
                        entries.add(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_LEAVES);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_PLANKS);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_SAPLING);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_WOOD);

                        //Crafting Blocks
                        entries.add(ModBlocks.STONE_BRICK_FORGE);
                        entries.add(ModBlocks.HEAVY_WORKBENCH);

                    }).build());

    public static void registerItemGroups() {

    }
}

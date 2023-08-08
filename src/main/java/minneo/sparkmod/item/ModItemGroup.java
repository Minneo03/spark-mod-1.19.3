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

public class ModItemGroup {
    public static ItemGroup SPARK = Registry.register(Registries.ITEM_GROUP, new Identifier(SparkMod.MOD_ID, "spark"),
            FabricItemGroup.builder()
                    .displayName(Text.literal("Spark Mod"))
                    .icon(() -> new ItemStack(ModItems.MINIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MINIUM);
                        entries.add(ModItems.RAW_MINIUM);

                        entries.add(ModBlocks.MINIUM_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_MINIUM_ORE);
                        entries.add(ModBlocks.MINIUM_ORE);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_LOG);
                        entries.add(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_LOG);
                        entries.add(ModBlocks.STRIPPED_WHITE_PHOSPHORUS_WOOD);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_LEAVES);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_PLANKS);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_SAPLING);
                        entries.add(ModBlocks.WHITE_PHOSPHORUS_WOOD);

                        entries.add(ModBlocks.BRICK_FORGE);

                    }).build()); //Most Recognizable Item in Mod);

    public static void registerItemGroups() {

    }
}

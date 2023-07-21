package minneo.sparkmod.item;

import minneo.sparkmod.SparkMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup SPARK;

    public static void registerItemGroups() {
        SPARK = FabricItemGroup.builder(new Identifier(SparkMod.MOD_ID, "spark"))
                .displayName(Text.literal("Spark Mod"))
                .icon(() -> new ItemStack(ModItems.MINIUM)).build(); //Most Recognizable Item in Mod
    }
}

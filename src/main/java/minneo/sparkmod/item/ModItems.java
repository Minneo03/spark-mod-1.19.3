package minneo.sparkmod.item;

import minneo.sparkmod.SparkMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //Minium
    public static final Item MINIUM = registerItem("minium", new Item(new FabricItemSettings()));
    public static final Item RAW_MINIUM = registerItem("raw_minium", new Item(new FabricItemSettings()));

    //Tungsten
    public static final Item TUNGSTEN = registerItem("tungsten", new Item(new FabricItemSettings()));
    public static final Item RAW_TUNGSTEN = registerItem("raw_tungsten", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SparkMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SparkMod.LOGGER.info("Registering Mod Items for " + SparkMod.MOD_ID);

    }

}

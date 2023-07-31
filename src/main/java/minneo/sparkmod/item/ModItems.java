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

    public static final Item MINIUM = registerItem("minium", new Item(new FabricItemSettings()));
    public static final Item RAW_MINIUM = registerItem("raw_minium", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SparkMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, MINIUM);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_MINIUM);

        addToItemGroup(ModItemGroup.SPARK, MINIUM);
        addToItemGroup(ModItemGroup.SPARK, RAW_MINIUM);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        SparkMod.LOGGER.info("Registering Mod Items for " + SparkMod.MOD_ID);

        addItemsToItemGroup();
    }

}

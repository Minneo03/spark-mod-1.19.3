package minneo.sparkmod.block.entity;

import minneo.sparkmod.SparkMod;
import minneo.sparkmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlockEntities {
    public static BlockEntityType<HeavyWorkbenchBlockEntity> HEAVY_WORKBENCH_BE;

    public static void registerBlockEntities() {
        HEAVY_WORKBENCH_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(SparkMod.MOD_ID, "heavy_workbench_be"),
                FabricBlockEntityTypeBuilder.create(HeavyWorkbenchBlockEntity::new,
                        ModBlocks.HEAVY_WORKBENCH).build(null));
    }
}

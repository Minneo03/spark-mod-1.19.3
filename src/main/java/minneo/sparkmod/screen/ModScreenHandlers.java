package minneo.sparkmod.screen;

import minneo.sparkmod.SparkMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<HeavyWorkbenchScreenHandler> HEAVY_WORKBENCH_SCREEN_HANDLER;


    public static void registerAllScreenHandlers() {
        HEAVY_WORKBENCH_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, new Identifier(SparkMod.MOD_ID, "heavy_workbench_screen_handler"),
                new ExtendedScreenHandlerType<>(HeavyWorkbenchScreenHandler::new));
    }
}

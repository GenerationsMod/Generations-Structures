package generations.gg.generations.modulename.generationsmodulename.forge;

import dev.architectury.platform.forge.EventBuses;
import generations.gg.generations.modulename.generationsmodulename.GenerationsModuleName;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GenerationsModuleName.MOD_ID)
public class GenerationsModuleNameForge {
    public GenerationsModuleNameForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GenerationsModuleName.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        GenerationsModuleName.init();
    }
}

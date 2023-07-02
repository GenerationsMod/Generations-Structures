package generations.gg.generations.structures.generationsstructures.forge;

import dev.architectury.platform.forge.EventBuses;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GenerationsStructures.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        GenerationsStructures.init();
    }
}

package generations.gg.generations.structures.generationsstructures.forge;

import dev.architectury.platform.forge.EventBuses;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.forge.integration.BOP;
import generations.gg.generations.structures.generationsstructures.forge.integration.BYGBOP;
import generations.gg.generations.structures.generationsstructures.forge.integration.BYGForge;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GenerationsStructures.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Integration integration;
        if (ModList.get().isLoaded("biomesoplenty") && ModList.get().isLoaded("byg")) integration = new BYGBOP();
        else if (ModList.get().isLoaded("biomesoplenty")) integration = new BOP();
        else if (ModList.get().isLoaded("byg")) integration = new BYGForge();
        else integration = new Default();
        GenerationsStructures.init(integration);
    }
}

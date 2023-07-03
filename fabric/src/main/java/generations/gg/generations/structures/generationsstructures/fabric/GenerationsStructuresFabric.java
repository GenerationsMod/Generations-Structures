package generations.gg.generations.structures.generationsstructures.fabric;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.byg.BYG;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Fabric initializer for Generations Structures
 * @see ModInitializer
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
public class GenerationsStructuresFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GenerationsStructures.init(FabricLoader.getInstance().isModLoaded("byg") ? new BYG() : new Default());
    }
}

package generations.gg.generations.structures.generationsstructures.fabric;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import net.fabricmc.api.ModInitializer;

/**
 * Fabric initializer for Generations Structures
 * @see ModInitializer
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
public class GenerationsStructuresFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GenerationsStructures.init(new Default());  //TODO: FabricLoader.getInstance().isModLoaded(potionstudios.byg.BYG.MOD_ID) ? new BYG() : new Default()
        StructureProcessors.init();
    }
}

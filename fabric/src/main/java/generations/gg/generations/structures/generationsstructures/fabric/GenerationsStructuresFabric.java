package generations.gg.generations.structures.generationsstructures.fabric;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.integration.BWG;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.potionstudios.biomeswevegone.BiomesWeveGone;

/**
 * Fabric initializer for Generations Structures
 * @see ModInitializer
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
public class GenerationsStructuresFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GenerationsStructures.init(FabricLoader.getInstance().isModLoaded(BiomesWeveGone.MOD_ID) ? new BWG() : new Default());
    }
}

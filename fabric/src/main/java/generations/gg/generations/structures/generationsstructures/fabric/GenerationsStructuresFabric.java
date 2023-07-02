package generations.gg.generations.structures.generationsstructures.fabric;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.fabric.integration.BYGFabric;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class GenerationsStructuresFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GenerationsStructures.init(FabricLoader.getInstance().isModLoaded("byg") ? new BYGFabric() : new Default());
    }
}

package generations.gg.generations.structures.generationsstructures.fabric;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.byg.BYG;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import generations.gg.generations.structures.generationsstructures.village.PlaceInVillage;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

/**
 * Fabric initializer for Generations Structures
 * @see ModInitializer
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
public class GenerationsStructuresFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GenerationsStructures.init(FabricLoader.getInstance().isModLoaded(potionstudios.byg.BYG.MOD_ID) ? new BYG() : new Default());
        StructureProcessors.init();
        PlaceInVillage.addStructuresToVillages();
    }
}

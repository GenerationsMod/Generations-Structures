package generations.gg.generations.structures.generationsstructures.forge;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.forge.integration.BOP;
import generations.gg.generations.structures.generationsstructures.forge.integration.BOPBWG;
import generations.gg.generations.structures.generationsstructures.integration.BWG;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

/**
 * Forge initializer for Generations Structures
 * @see Mod
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        Integration integration;
        boolean isBOP = ModList.get().isLoaded(biomesoplenty.core.BiomesOPlenty.MOD_ID);
        boolean isBWG = ModList.get().isLoaded(net.potionstudios.biomeswevegone.BiomesWeveGone.MOD_ID);
        if (isBOP && isBWG) integration = new BOPBWG();
        else if (isBOP) integration = new BOP();
        else if (isBWG) integration = new BWG();
        else integration = new Default();
        GenerationsStructures.init(integration);
    }
}

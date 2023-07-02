package generations.gg.generations.structures.generationsstructures.forge.integration;

import biomesoplenty.core.BiomesOPlenty;
import generations.gg.generations.structures.generationsstructures.integration.Integration;

public class BOP implements Integration {
    @Override
    public String getModId() {
        return BiomesOPlenty.MOD_ID;
    }
}

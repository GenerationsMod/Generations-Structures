package generations.gg.generations.structures.generationsstructures.forge.integration;

import biomesoplenty.core.BiomesOPlenty;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

/**
 * Integration for Biomes O' Plenty and Oh the Biomes you'll go. When both are on server
 * @see <a href="https://github.com/Glitchfiend/BiomesOPlenty">Biomes O' Plenty</a>
 * @see <a href="https://github.com/AOCAWOL/BYG">BYG</a>
 * @see Integration
 * @author J.T. McQuigg (JT122406)
 */
public class BYGBOP implements Integration {
    @Override
    public String getModId() {
        return BYG.MOD_ID + BiomesOPlenty.MOD_ID;
    }

    @Override
    public Block getBirchTrapdoorReplacement() {
        return BYGWoodTypes.WITCH_HAZEL.trapdoor().get();
    }

    @Override
    public Block getGhostTrapdoorReplacement() {
        return BYGWoodTypes.EBONY.trapdoor().get();
    }
}

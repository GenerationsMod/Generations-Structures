package generations.gg.generations.structures.generationsstructures.integration;

import net.minecraft.world.level.block.Block;

/**
 * Integration interface for Generations Structures
 * This interface is used to assign values to the integration fields
 * This interface is implemented by the integration classes
 * @author J.T. McQuigg (JT122406)
 */
public interface Integration {

    /**
     * Returns the mod id of the integration
     * @return the mod id of the integration
     */
    String getModId();

    /**
     * Returns the block to replace birch trapdoors with
     * @return Block to replace birch trapdoors with
     */
    Block getBirchTrapdoorReplacement();

    /**
     * Returns the block to replace ghost trapdoors with
     * @return Block to replace ghost trapdoors with
     */
    Block getGhostTrapdoorReplacement();
}

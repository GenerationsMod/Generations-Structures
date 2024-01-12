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

    /**
     * Returns the block to replace Oak Leaves with
     * @return Block to replace oak leaves with
     */
    Block getOakLeavesReplacement();

    /**
     * Returns the block to replace the mirrored floor with
     * @return Block to replace the mirrored floor with
     */
    Block getMirroredFloorReplacement();

    /**
     * Returns the block to replace the red tulip with
     * @return Block to replace the red tulip with
     */
    Block getRedTulipReplacement();

    /**
     * Returns the block to replace the pink tulip with
     * @return Block to replace the pink tulip with
     */
    Block getPinkTulipReplacement();

    /**
     * Returns the block to replace the white castle brick 2 set slab with
     * @return Block to replace the white castle brick 2 set slab with
     */
    Block getWhiteCastleBrick2SetSlabReplacement();
}

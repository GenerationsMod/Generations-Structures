package generations.gg.generations.structures.generationsstructures.forge.integration;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.core.BiomesOPlenty;
import generations.gg.generations.core.generationscore.world.level.block.GenerationsBlocks;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

/**
 * Integration for Biomes O' Plenty.
 * @see <a href="https://github.com/Glitchfiend/BiomesOPlenty">Biomes O' Plenty</a>
 * @see Integration
 * @author J.T. McQuigg (JT122406)
 */
public class BOP implements Integration {
    @Override
    public String getModId() {
        return BiomesOPlenty.MOD_ID;
    }

    @Override
    public Block getBirchTrapdoorReplacement() {
        return Blocks.BIRCH_TRAPDOOR;
    }

    @Override
    public Block getGhostTrapdoorReplacement() {
        return BOPBlocks.HELLBARK_TRAPDOOR.get();
    }

    @Override
    public Block getOakLeavesReplacement() {
        return BOPBlocks.FLOWERING_OAK_LEAVES.get();
    }

    @Override
    public Block getMirroredFloorReplacement() {
        return BOPBlocks.SMOOTH_WHITE_SANDSTONE.get();
    }

    @Override
    public Block getRedTulipReplacement() {
        return BOPBlocks.POTTED_ROSE.get();
    }

    @Override
    public Block getPinkTulipReplacement() {
        return BOPBlocks.POTTED_VIOLET.get();
    }

    @Override
    public Block getWhiteCastleBrick2SetSlabReplacement() {
        return GenerationsBlocks.WHITE_CASTLE_BRICK_2_SET.getSlab();
    }
}

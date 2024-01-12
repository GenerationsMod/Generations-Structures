package generations.gg.generations.structures.generationsstructures.byg;

import generations.gg.generations.core.generationscore.world.level.block.GenerationsBlocks;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;

/**
 * Integration for the Oh the Biomes you'll go.
 * @see <a href="https://github.com/AOCAWOL/BYG">BYG</a>
 * @see Integration
 * @author J.T. McQuigg (JT122406)
 */
public class BYG implements Integration {
    @Override
    public String getModId() {
        return potionstudios.byg.BYG.MOD_ID;
    }

    @Override
    public Block getBirchTrapdoorReplacement() {
        return BYGWoodTypes.WITCH_HAZEL.trapdoor().get();
    }

    @Override
    public Block getGhostTrapdoorReplacement() {
        return BYGWoodTypes.EBONY.trapdoor().get();
    }

    @Override
    public Block getOakLeavesReplacement() {
        return Blocks.OAK_LEAVES;
    }

    @Override
    public Block getMirroredFloorReplacement() {
        return GenerationsBlocks.MIRRORED_FLOOR_3_SET.getBaseBlock();
    }

    @Override
    public Block getRedTulipReplacement() {
        return Blocks.POTTED_RED_TULIP;
    }

    @Override
    public Block getPinkTulipReplacement() {
        return Blocks.POTTED_PINK_TULIP;
    }

    @Override
    public Block getWhiteCastleBrick2SetSlabReplacement() {
        return BYGBlocks.TRAVERTINE_SLAB.get();
    }
}

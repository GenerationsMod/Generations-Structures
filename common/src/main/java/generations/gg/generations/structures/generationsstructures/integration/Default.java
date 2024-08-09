package generations.gg.generations.structures.generationsstructures.integration;


import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsBlocks;
import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsWood;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

/**
 * Default integration class for Generations Structures
 * This class is ignored by the mod and is used to assign a default value to the integration fields
 * @see Integration
 * @author J.T. McQuigg (JT122406)
 */
public class Default implements Integration {
    @Override
    public @Nullable String getModId() {
        return null;
    }

    @Override
    public Block getBirchTrapdoorReplacement() {
        return Blocks.BIRCH_TRAPDOOR;
    }

    @Override
    public Block getGhostTrapdoorReplacement() {
        return GenerationsWood.GHOST_TRAPDOOR.get();
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
        return GenerationsBlocks.WHITE_CASTLE_BRICK_2_SET.getSlab();
    }
}

package generations.gg.generations.structures.generationsstructures.integration;

import generations.gg.generations.core.generationscore.world.level.block.GenerationsWood;
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
}

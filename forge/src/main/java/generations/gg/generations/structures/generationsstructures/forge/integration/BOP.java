package generations.gg.generations.structures.generationsstructures.forge.integration;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.core.BiomesOPlenty;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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
}

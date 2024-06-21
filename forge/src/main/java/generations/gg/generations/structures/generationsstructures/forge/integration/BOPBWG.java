package generations.gg.generations.structures.generationsstructures.forge.integration;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.core.BiomesOPlenty;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.world.level.block.Block;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWood;
import org.jetbrains.annotations.Nullable;

public class BOPBWG implements Integration {
    @Override
    public @Nullable String getModId() {
        return BiomesOPlenty.MOD_ID + BiomesWeveGone.MOD_ID;
    }

    @Override
    public Block getBirchTrapdoorReplacement() {
        return BWGWood.WITCH_HAZEL.trapdoor();
    }

    @Override
    public Block getGhostTrapdoorReplacement() {
        return BWGWood.EBONY.trapdoor();
    }

    @Override
    public Block getOakLeavesReplacement() {
        return BOPBlocks.FLOWERING_OAK_LEAVES.get();
    }

    @Override
    public Block getMirroredFloorReplacement() {
        return null;
    }

    @Override
    public Block getRedTulipReplacement() {
        return null;
    }

    @Override
    public Block getPinkTulipReplacement() {
        return null;
    }

    @Override
    public Block getWhiteCastleBrick2SetSlabReplacement() {
        return null;
    }
}

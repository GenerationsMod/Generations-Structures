package generations.gg.generations.structures.generationsstructures.integration;

import net.minecraft.world.level.block.Block;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWood;
import org.jetbrains.annotations.Nullable;

public class BWG implements Integration {
    @Override
    public @Nullable String getModId() {
        return BiomesWeveGone.MOD_ID;
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
        return BWGWood.FLOWERING_ORCHARD_LEAVES.get();
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

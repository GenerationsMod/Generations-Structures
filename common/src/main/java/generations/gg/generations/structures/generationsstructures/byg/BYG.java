package generations.gg.generations.structures.generationsstructures.byg;

import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.common.block.BYGWoodTypes;

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
}

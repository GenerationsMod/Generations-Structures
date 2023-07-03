package generations.gg.generations.structures.generationsstructures.integration;

import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class Default implements Integration {
    @Override
    public @Nullable String getModId() {
        return null;
    }

    @Override
    public Block getBirchTrapdoorReplacement() {
        return null;
    }

    @Override
    public Block getGhostTrapdoorReplacement() {
        return null;
    }
}

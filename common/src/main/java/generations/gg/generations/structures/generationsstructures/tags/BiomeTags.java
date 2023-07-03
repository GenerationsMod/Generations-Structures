package generations.gg.generations.structures.generationsstructures.tags;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeTags {
    public static final TagKey<Biome> HAS_SCARLET_POKESHOP = create("has_structure/scarlet_pokeshop");

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, GenerationsStructures.id(name));
    }
}

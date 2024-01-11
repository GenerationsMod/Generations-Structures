package generations.gg.generations.structures.generationsstructures.tags;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

/**
 * Contains all the {@link TagKey}s for the generation of structures in the mod.
 */
public class GenerationsBiomeTags {

    public static final TagKey<Biome> IS_NOT_MOUNTAIN = create("is_not_mountain");

    /** the tag for biomes that have a Scarlet Pokeshop */
    public static final TagKey<Biome> HAS_SCARLET_POKESHOP = create("has_structure/scarlet_pokeshop");

    /** the tag for biomes that have a Loot Balloon */
    public static final TagKey<Biome> HAS_LOOT_BALLOON = create("has_structure/loot_balloon");

    /** the tag for biomes that can have a comet */
    public static final TagKey<Biome> HAS_COMET = create("has_structure/comet");

    /** the tag for biomes that can have a spike */
    public static final TagKey<Biome> HAS_SPIKE = create("has_structure/spike");

    /** the tag for biomes that can have a frozen shrine */
    public static final TagKey<Biome> HAS_FROZEN_SHRINE = create("has_structure/frozen_shrine");

    /**
     * Creates a new {@link TagKey} for the given name.
     * @param name The name of the tag.
     * @return The created {@link TagKey}.
     */
    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, GenerationsStructures.id(name));
    }
}

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
    public static final TagKey<Biome> HAS_POKECENTER = create("has_structure/pokecenter");

    /** the tag for biomes that have a Loot Balloon */
    public static final TagKey<Biome> HAS_LOOT_BALLOON = create("has_structure/loot_balloon");

    /** the tag for biomes that can have a comet */
    public static final TagKey<Biome> HAS_COMET = create("has_structure/comet");

    /** the tag for biomes that can have an island */
    public static final TagKey<Biome> HAS_ISLANDS = create("has_structure/islands");

    /** the tag for biomes that can have a frozen shrine */
    public static final TagKey<Biome> HAS_FROZEN_SHRINE = create("has_structure/frozen_shrine");

    /** the tag for biomes that can have a fiery shrine */
    public static final TagKey<Biome> HAS_FIERY_SHRINE = create("has_structure/fiery_shrine");

    /** the tag for biomes that can have a static shrine */
    public static final TagKey<Biome> HAS_STATIC_SHRINE = create("has_structure/static_shrine");

    /** the tag for biomes that can have a Lugia shrine */
    public static final TagKey<Biome> HAS_LUGIA_SHRINE = create("has_structure/lugia_shrine");

    /**
     * Creates a new {@link TagKey} for the given name.
     * @param name The name of the tag.
     * @return The created {@link TagKey}.
     */
    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, GenerationsStructures.id(name));
    }
}

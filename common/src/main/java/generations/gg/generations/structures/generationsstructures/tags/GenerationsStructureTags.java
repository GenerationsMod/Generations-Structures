package generations.gg.generations.structures.generationsstructures.tags;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class GenerationsStructureTags {

    public static final TagKey<Structure> POKESHOP = create("pokeshop");
    public static final TagKey<Structure> LOOT_BALLOON = create("loot_balloon");

    /**
     * Creates a new {@link TagKey} for the given name.
     * @param name The name of the tag.
     * @return The created {@link TagKey}.
     */
    private static TagKey<Structure> create(String name) {
        return TagKey.create(Registries.STRUCTURE, GenerationsStructures.id(name));
    }
}

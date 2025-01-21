package generations.gg.generations.structures.generationsstructures.tags;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface GenerationsStructureTags {

    TagKey<Structure> GENERATIONS_STRUCTURES = create("generations_structures");

    TagKey<Structure> POKESHOP = create("pokeshop");
    TagKey<Structure> LOOT_BALLOONS = create("loot_balloons");
    TagKey<Structure> GYMS = create("gyms");
    TagKey<Structure> SHRINES = create("shrines");

    /**
     * Creates a new {@link TagKey} for the given name.
     * @param name The name of the tag.
     * @return The created {@link TagKey}.
     */
    private static TagKey<Structure> create(String name) {
        return TagKey.create(Registries.STRUCTURE, GenerationsStructures.id(name));
    }
}

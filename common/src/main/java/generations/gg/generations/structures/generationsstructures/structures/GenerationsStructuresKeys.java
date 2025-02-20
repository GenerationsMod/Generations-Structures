package generations.gg.generations.structures.generationsstructures.structures;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

/**
 * This class is used to store all the structure keys for the mod.
 * @author J.T. McQuigg
 */
public interface GenerationsStructuresKeys {

    /** Scarlet Pokeshop Structure ResourceKey **/
    ResourceKey<Structure> SCARLET_POKECENTER_ANTENNA = createKey("scarlet_pokecenter_antenna");

    /** Villages Structure ResourceKeys **/
    ResourceKey<Structure> PLAINS_POKEMART_STREET_STRAIGHT_05 = createKey("village/plains/streets/pokemart/straight_05");
    ResourceKey<Structure> PLAINS_POKEMART_STREET_CORNER_01 = createKey("village/plains/streets/pokemart/corner_01");
    ResourceKey<Structure> PLAINS_POKEMART_1 = createKey("village/plains/pokemart_1");
    ResourceKey<Structure> PLAINS_POKEMART_2 = createKey("village/plains/pokemart_2");
    ResourceKey<Structure> PLAINS_POKEMART_3 = createKey("village/plains/pokemart_3");
    ResourceKey<Structure> PLAINS_POKECENTER_STREET_STRAIGHT_05 = createKey("village/plains/streets/pokecenter/straight_05");
    ResourceKey<Structure> PLAINS_POKECENTER_STREET_CORNER_01 = createKey("village/plains/streets/pokecenter/corner_01");
    ResourceKey<Structure> PLAINS_POKECENTER_1 = createKey("village/plains/pokecenter_1");
    ResourceKey<Structure> PLAINS_POKECENTER_2 = createKey("village/plains/pokecenter_2");
    ResourceKey<Structure> PLAINS_POKECENTER_3 = createKey("village/plains/pokecenter_3");


    ResourceKey<Structure> DESERT_POKEMART_STREET_STRAIGHT_05 = createKey("village/desert/streets/pokemart/straight_05");
    ResourceKey<Structure> DESERT_POKEMART_STREET_CORNER_01 = createKey("village/desert/streets/pokemart/corner_01");
    ResourceKey<Structure> DESERT_POKECENTER_STREET_STRAIGHT_05 = createKey("village/desert/streets/pokecenter/straight_05");
    ResourceKey<Structure> DESERT_POKECENTER_STREET_CORNER_01 = createKey("village/desert/streets/pokecenter/corner_01");
    ResourceKey<Structure> DESERT_POKEMART_1 = createKey("village/desert/pokemart_1");
    ResourceKey<Structure> DESERT_POKEMART_2 = createKey("village/desert/pokemart_2");
    ResourceKey<Structure> DESERT_POKEMART_3 = createKey("village/desert/pokemart_3");
    ResourceKey<Structure> DESERT_POKECENTER_1 = createKey("village/desert/pokecenter_1");
    ResourceKey<Structure> DESERT_POKECENTER_2 = createKey("village/desert/pokecenter_2");
    ResourceKey<Structure> DESERT_POKECENTER_3 = createKey("village/desert/pokecenter_3");

    ResourceKey<Structure> CREATION_TRIO_TOP = createKey("shrines/creation_trio_top");
    /**
     * Creates a ResourceKey for the structure.
     * @param name The name of the structure or directory with name.
     * @return ResourceKey<Structure>
     */
    private static ResourceKey<Structure> createKey(String name) {
        return GenerationsStructures.key(Registries.STRUCTURE, name);
    }
}

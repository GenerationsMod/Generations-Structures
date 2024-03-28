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
    ResourceKey<Structure> SCARLET_POKECENTER = createKey("scarlet_pokecenter");
    ResourceKey<Structure> SCARLET_POKECENTER_ANTENNA = createKey("scarlet_pokecenter_antenna");

    /** Loot Balloon Structure ResourceKeys **/
    ResourceKey<Structure> POKE_BALLOON = createKey("loot_balloon/poke_balloon");
    ResourceKey<Structure> GREAT_BALLOON = createKey("loot_balloon/great_balloon");
    ResourceKey<Structure> ULTRA_BALLOON = createKey("loot_balloon/ultra_balloon");
    ResourceKey<Structure> MASTER_BALLOON = createKey("loot_balloon/master_balloon");
    ResourceKey<Structure> BEAST_BALLOON = createKey("loot_balloon/beast_balloon");
    ResourceKey<Structure> MEOWTH_BALLOON = createKey("loot_balloon/meowth_balloon");

    /** Nether Spike Structure ResourceKey **/
    ResourceKey<Structure> SPIKE = createKey("spike");

    /** Comet Structure ResourceKey **/
    ResourceKey<Structure> COMET = createKey("comet");

    /** PokeShop Structure ResourceKey **/
    ResourceKey<Structure> LARGE_POKESHOP = createKey("large_pokeshop");

    /** PokeCenter Structure ResourceKey **/
    ResourceKey<Structure> LARGE_POKECENTER = createKey("large_pokecenter");

    /** Island Structure ResourceKey **/
    ResourceKey<Structure> ISLANDS = createKey("islands");

    /** Shrines Structure ResourceKeys **/
    ResourceKey<Structure> FROZEN_SHRINE = createKey("shrines/frozen_shrine");
    ResourceKey<Structure> FIERY_SHRINE = createKey("shrines/fiery_shrine");
    ResourceKey<Structure> STATIC_SHRINE = createKey("shrines/static_shrine");
    ResourceKey<Structure> LUGIA_SHRINE = createKey("shrines/lugia_shrine");

    /** Villages Structure ResourceKeys **/
    ResourceKey<Structure> PLAINS_POKEMART_1 = createKey("village/plains/pokemart_1");
    ResourceKey<Structure> PLAINS_POKECENTER_1 = createKey("village/plains/pokecenter_1");

    /**
     * Creates a ResourceKey for the structure.
     * @param name The name of the structure or directory with name.
     * @return ResourceKey<Structure>
     */
    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, GenerationsStructures.id(name));
    }
}

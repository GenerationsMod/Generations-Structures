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
    ResourceKey<Structure> SCARLET_POKESHOP = createKey("scarlet_pokeshop");

    /** Loot Balloon Structure ResourceKeys **/
    ResourceKey<Structure> NORMAL_BALLOON = createKey("loot_balloon/normal_balloon");
    ResourceKey<Structure> GREAT_BALLOON = createKey("loot_balloon/great_balloon");
    ResourceKey<Structure> ULTRA_BALLOON = createKey("loot_balloon/ultra_balloon");
    ResourceKey<Structure> MASTER_BALLOON = createKey("loot_balloon/master_balloon");
    ResourceKey<Structure> BEAST_BALLOON = createKey("loot_balloon/beast_balloon");
    ResourceKey<Structure> MEOWTH_BALLOON = createKey("loot_balloon/meowth_balloon");

    /**
     * Creates a ResourceKey for the structure.
     * @param name The name of the structure or directory with name.
     * @return ResourceKey<Structure>
     */
    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, GenerationsStructures.id(name));
    }
}
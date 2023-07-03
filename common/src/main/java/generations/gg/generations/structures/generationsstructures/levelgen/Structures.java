package generations.gg.generations.structures.generationsstructures.levelgen;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public interface Structures {
    ResourceKey<Structure> SCARLET_POKESHOP = createKey("scarlet_pokeshop");

    private static ResourceKey<Structure> createKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, GenerationsStructures.id(name));
    }
}

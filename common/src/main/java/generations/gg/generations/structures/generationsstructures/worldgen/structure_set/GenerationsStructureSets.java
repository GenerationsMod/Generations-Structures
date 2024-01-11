package generations.gg.generations.structures.generationsstructures.worldgen.structure_set;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

import java.util.List;


/**
 * This class is used to hold all the Structure Sets
 * @see StructureSet
 * @author Joseph T. McQuigg
 */
public class GenerationsStructureSets {
    public static ResourceKey<StructureSet> LOOT_BALLOON = create("loot_balloon");
    public static ResourceKey<StructureSet> COMET = create("comet");
    public static ResourceKey<StructureSet> POKESHOPS = create("pokeshops");
    public static ResourceKey<StructureSet> SPIKE = create("spike");
    public static ResourceKey<StructureSet> FROZEN_SHRINE = create("frozen_shrine");

    /**
     * This method is used to bootstrap the structure sets.
     * @param context The bootstrap context
     */
    public static void bootstrap(BootstapContext<StructureSet> context) {
        register(context, COMET, GenerationsStructuresKeys.COMET,
                new RandomSpreadStructurePlacement(150, 85, RandomSpreadType.LINEAR, 1189082690));

        register(context, POKESHOPS, GenerationsStructuresKeys.SCARLET_POKESHOP,
                new RandomSpreadStructurePlacement(500, 250, RandomSpreadType.LINEAR, 293756737));

        register(context, SPIKE, GenerationsStructuresKeys.SPIKE,
                new RandomSpreadStructurePlacement(20, 10, RandomSpreadType.LINEAR, 732790531));

        register(context,
          LOOT_BALLOON,
                List.of(
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.GREAT_BALLOON, 4),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.MASTER_BALLOON, 1),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.ULTRA_BALLOON, 2),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.BEAST_BALLOON, 2),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.MEOWTH_BALLOON, 3),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.POKE_BALLOON, 5)
                ), new RandomSpreadStructurePlacement(100, 50, RandomSpreadType.LINEAR, 738478911)
        );

        register(context, FROZEN_SHRINE, GenerationsStructuresKeys.FROZEN_SHRINE,
                new RandomSpreadStructurePlacement(4096, 500, RandomSpreadType.LINEAR, 989914746));
    }

    /**
     * Registers a structure set with the given key and structure.
     * @param context The bootstrap context
     * @param key The key for the structure set
     * @param structure The structure to register
     * @param placement The placement for the structure set
     */
    private static void register(BootstapContext<StructureSet> context, ResourceKey<StructureSet> key, ResourceKey<Structure> structure, StructurePlacement placement) {
        context.register(key, new StructureSet(context.lookup(Registries.STRUCTURE).getOrThrow(structure), placement));
    }


    /**
     * Registers a structure set with the given key and structure selection entries.
     * @param context The bootstrap context
     * @param key The key for the structure set
     * @param structureSelectionEntries The structure selection entries to register
     * @param placement The placement for the structure set
     */
    private static void register(BootstapContext<StructureSet> context, ResourceKey<StructureSet> key, List<StructureSet.StructureSelectionEntry> structureSelectionEntries, StructurePlacement placement) {
        context.register(key, new StructureSet(structureSelectionEntries, placement));
    }

    /**
     * Creates a ResourceKey for the structure set.
     * @param name of the structure set or directory with name.
     * @return ResourceKey<StructureSet>
     */
    private static ResourceKey<StructureSet> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, GenerationsStructures.id(name));
    }

    /**
     * Creates a StructureSelectionEntry for the structure set.
     * @param context The bootstrap context
     * @param structure The structure to register
     * @param weight The weight of the structure
     * @return StructureSet.StructureSelectionEntry
     */
    private static StructureSet.StructureSelectionEntry createStructureSelectionEntry(BootstapContext<StructureSet> context, ResourceKey<Structure> structure, int weight) {
        return new StructureSet.StructureSelectionEntry(context.lookup(Registries.STRUCTURE).getOrThrow(structure), weight);
    }
}

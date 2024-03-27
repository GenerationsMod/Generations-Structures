package generations.gg.generations.structures.generationsstructures.worldgen.structure_set;

import com.google.common.collect.ImmutableList;
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
    private static final ResourceKey<StructureSet> LOOT_BALLOON = create("loot_balloon");
    private static final ResourceKey<StructureSet> COMET = create("comet");
    private static final ResourceKey<StructureSet> POKESHOPS = create("pokeshops");
    private static final ResourceKey<StructureSet> SPIKE = create("spike");
    private static final ResourceKey<StructureSet> FROZEN_SHRINE = create("shrines/frozen_shrine");
    private static final ResourceKey<StructureSet> FIERY_SHRINE = create("shrines/fiery_shrine");
    private static final ResourceKey<StructureSet> STATIC_SHRINE = create("shrines/static_shrine");
    private static final ResourceKey<StructureSet> LUGIA_SHRINE = create("shrines/lugia_shrine");
    private static final ResourceKey<StructureSet> ISLANDS = create("islands");

    /**
     * This method is used to bootstrap the structure sets.
     * @param context The bootstrap context
     */
    public static void bootstrap(BootstapContext<StructureSet> context) {
        register(context, COMET, GenerationsStructuresKeys.COMET,
                new RandomSpreadStructurePlacement(150, 85, RandomSpreadType.LINEAR, 1189082690));

        register(context, POKESHOPS,
                ImmutableList.of(
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.SCARLET_POKECENTER, 1),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.LARGE_POKECENTER, 1)
                ),
                new RandomSpreadStructurePlacement(400, 250, RandomSpreadType.LINEAR, 293756737));

        register(context, SPIKE, GenerationsStructuresKeys.SPIKE,
                new RandomSpreadStructurePlacement(20, 10, RandomSpreadType.LINEAR, 732790531));

        register(context,
          LOOT_BALLOON,
                ImmutableList.of(
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.GREAT_BALLOON, 4),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.MASTER_BALLOON, 1),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.ULTRA_BALLOON, 2),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.BEAST_BALLOON, 2),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.MEOWTH_BALLOON, 3),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.POKE_BALLOON, 5)
                ), new RandomSpreadStructurePlacement(100, 45, RandomSpreadType.LINEAR, 738478911)
        );

        register(context, ISLANDS, GenerationsStructuresKeys.ISLANDS,
                new RandomSpreadStructurePlacement(100, 45, RandomSpreadType.LINEAR, 347680677));

        register(context, FROZEN_SHRINE, GenerationsStructuresKeys.FROZEN_SHRINE,
                new RandomSpreadStructurePlacement(2000, 350, RandomSpreadType.LINEAR, 989914746));

        register(context, FIERY_SHRINE, GenerationsStructuresKeys.FIERY_SHRINE,
                new RandomSpreadStructurePlacement(2000, 350, RandomSpreadType.LINEAR, 333897074));

        register(context, STATIC_SHRINE, GenerationsStructuresKeys.STATIC_SHRINE,
                new RandomSpreadStructurePlacement(2000, 350, RandomSpreadType.LINEAR, 442038945));

        register(context, LUGIA_SHRINE, GenerationsStructuresKeys.LUGIA_SHRINE,
                new RandomSpreadStructurePlacement(2000, 350, RandomSpreadType.LINEAR, 751341351));
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

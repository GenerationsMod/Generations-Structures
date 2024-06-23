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

    /**
     * This method is used to bootstrap the structure sets.
     * @param context The bootstrap context
     */
    public static void bootstrap(BootstapContext<StructureSet> context) {
        register(context, "comet", GenerationsStructuresKeys.COMET, 150, 85, 1189082690);

        register(context, "pokeshops",
                ImmutableList.of(
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.SCARLET_POKECENTER, 1),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.LARGE_POKECENTER, 1)
                ), 400, 250, 293756737);

        register(context,
                "loot_balloon",
                ImmutableList.of(
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.GREAT_BALLOON, 4),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.MASTER_BALLOON, 1),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.ULTRA_BALLOON, 2),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.BEAST_BALLOON, 2),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.MEOWTH_BALLOON, 3),
                        createStructureSelectionEntry(context, GenerationsStructuresKeys.POKE_BALLOON, 5)
                ), 100, 45, 738478911);

        register(context, "islands", GenerationsStructuresKeys.ISLANDS, 100, 45, 347680677);

        register(context, "shrines/frozen_shrine", GenerationsStructuresKeys.FROZEN_SHRINE, 2000, 350, 989914746);

        register(context, "shrines/fiery_shrine", GenerationsStructuresKeys.FIERY_SHRINE, 2000, 350, 333897074);

        register(context, "shrines/static_shrine", GenerationsStructuresKeys.STATIC_SHRINE, 2000, 350, 442038945);

        register(context, "shrines/lugia_shrine", GenerationsStructuresKeys.LUGIA_SHRINE, 2000, 350, 751341351);
    }

    /**
     * Registers a structure set with the given key and structure.
     * @param context The bootstrap context
     * @param id The key for the structure set ResourceKey
     * @param structure The structure to register
     * @param spacing The spacing for the structure set
     * @param seperation The seperation for the structure set
     * @param salt The salt for the structure set
     */
    private static void register(BootstapContext<StructureSet> context, String id, ResourceKey<Structure> structure, int spacing, int seperation, int salt) {
        register(context, id, structure, new RandomSpreadStructurePlacement(spacing, seperation, RandomSpreadType.LINEAR, salt));
    }

    /**
     * Registers a structure set with the given key and structure.
     * @param context The bootstrap context
     * @param id The id for the structure set ResourceKey
     * @param structure The structure to register
     * @param placement The placement for the structure set
     */
    private static void register(BootstapContext<StructureSet> context, String id, ResourceKey<Structure> structure, StructurePlacement placement) {
        context.register(create(id), new StructureSet(context.lookup(Registries.STRUCTURE).getOrThrow(structure), placement));
    }


    /**
     * Registers a structure set with the given key and structure selection entries.
     * @param context The bootstrap context
     * @param id The id for the structure set ResourceKey
     * @param structureSelectionEntries The structure selection entries to register
     * @param spacing The spacing for the structure set
     * @param seperation The seperation for the structure set
     * @param salt The salt for the structure set
     */
    private static void register(BootstapContext<StructureSet> context, String id, List<StructureSet.StructureSelectionEntry> structureSelectionEntries, int spacing, int seperation, int salt) {
        context.register(create(id), new StructureSet(structureSelectionEntries, new RandomSpreadStructurePlacement(spacing, seperation, RandomSpreadType.LINEAR, salt)));
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

package generations.gg.generations.structures.generationsstructures.worldgen.structure_set;

import com.google.common.collect.ImmutableList;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructureSettings;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;
import java.util.Map;


/**
 * This class is used to hold all the Structure Sets
 * @see StructureSet
 * @author Joseph T. McQuigg
 */
public class GenerationsStructureSets {

    public static final Map<ResourceKey<StructureSet>, StructureSetFactory> STRUCTURE_SET_FACTORIES = new Reference2ObjectOpenHashMap<>();


    /**
     * This method is used to bootstrap the structure sets.
     */
    public static void init() {
        register("comet", GenerationsStructureSettings.COMET, 150, 85, 1189082690);

        register("pokeshops",
                structureHolderGetter -> new StructureSet(
                ImmutableList.of(
                        createStructureSelectionEntry(structureHolderGetter, GenerationsStructureSettings.SCARLET_POKECENTER),
                        createStructureSelectionEntry(structureHolderGetter, GenerationsStructureSettings.LARGE_POKECENTER)
                ), createRandomLinearSpreadPlacement(400, 250, 293756737)));

        register("loot_balloon",
                structureHolderGetter -> new StructureSet(
                ImmutableList.of(
                        createStructureSelectionEntry(structureHolderGetter,GenerationsStructureSettings.GREAT_BALLOON, 4),
                        createStructureSelectionEntry(structureHolderGetter,GenerationsStructureSettings.MASTER_BALLOON),
                        createStructureSelectionEntry(structureHolderGetter,GenerationsStructureSettings.ULTRA_BALLOON, 2),
                        createStructureSelectionEntry(structureHolderGetter,GenerationsStructureSettings.BEAST_BALLOON, 2),
                        createStructureSelectionEntry(structureHolderGetter,GenerationsStructureSettings.MEOWTH_BALLOON, 3),
                        createStructureSelectionEntry(structureHolderGetter,GenerationsStructureSettings.POKE_BALLOON, 5)
                ), createRandomLinearSpreadPlacement(100, 45, 738478911)));

        register("islands", GenerationsStructureSettings.ISLANDS, 100, 45, 347680677);

        register("shrines/frozen", GenerationsStructureSettings.FROZEN_SHRINE, 2000, 350, 989914746);

        register("shrines/fiery", GenerationsStructureSettings.FIERY_SHRINE, 2000, 350, 333897074);

        register("shrines/static", GenerationsStructureSettings.STATIC_SHRINE, 2000, 350, 442038945);

        register("shrines/lugia", GenerationsStructureSettings.LUGIA_SHRINE, 2000, 350, 495104284);

        register("shrines/regi", GenerationsStructureSettings.REGI_SHRINE, 2000, 350, 423098801);

        register("shrines/creation_trio", GenerationsStructureSettings.CREATION_TRIO_SHRINE, 2000, 350, 913433717);

        register("shrines/forces_of_nature", GenerationsStructureSettings.FORCES_OF_NATURE_SHRINE, 2000, 350, 748320000);

        register("shrines/groudon", GenerationsStructureSettings.GROUDON_SHRINE, 2000, 350, 629507014);

        register("shrines/tapu", GenerationsStructureSettings.TAPU_SHRINE, 2000, 350, 647365027);
    }

    private static void register(String id, StructureSetFactory factory) {
        STRUCTURE_SET_FACTORIES.put(create(id), factory);
    }

    @FunctionalInterface
    public interface StructureSetFactory {
        StructureSet generate(HolderGetter<Structure> placedFeatureHolderGetter);
    }

    /**
     * Registers a structure set with the given key and structure selection entries.
     * @param id The id for the structure set ResourceKey
     * @param spacing The spacing for the structure set
     * @param seperation The seperation for the structure set
     * @param salt The salt for the structure set
     */
    private static void register(String id, ResourceKey<Structure> structure, int spacing, int seperation, int salt) {
        register(id, structureHolderGetter -> new StructureSet(ImmutableList.of(createStructureSelectionEntry(structureHolderGetter, structure)), createRandomLinearSpreadPlacement(spacing, seperation, salt)));
    }

    /**
     * Registers a structure set with the given key and structure selection entries.
     * @param id The id for the structure set ResourceKey
     * @param structureSelectionEntries The structure selection entries to register
     * @param spacing The spacing for the structure set
     * @param seperation The seperation for the structure set
     * @param salt The salt for the structure set
     */
    private static void register(String id, List<StructureSet.StructureSelectionEntry> structureSelectionEntries, int spacing, int seperation, int salt) {
        register(id, structureHolderGetter -> new StructureSet(structureSelectionEntries, createRandomLinearSpreadPlacement(spacing, seperation, salt)));
    }

    /**
     * Creates a ResourceKey for the structure set.
     * @param name of the structure set or directory with name.
     * @return ResourceKey<StructureSet>
     */
    private static ResourceKey<StructureSet> create(String name) {
        return GenerationsStructures.key(Registries.STRUCTURE_SET, name);
    }

    /**
     * Creates a StructureSelectionEntry for the structure set.
     * @param context The bootstrap context
     * @param structure The structure to register
     * @return StructureSet.StructureSelectionEntry
     */
    private static StructureSet.StructureSelectionEntry createStructureSelectionEntry(HolderGetter<Structure> context, ResourceKey<Structure> structure) {
        return createStructureSelectionEntry(context, structure, 1);
    }

    /**
     * Creates a StructureSelectionEntry for the structure set.
     * @param context The bootstrap context
     * @param structure The structure to register
     * @param weight The weight of the structure
     * @return StructureSet.StructureSelectionEntry
     */
    private static StructureSet.StructureSelectionEntry createStructureSelectionEntry(HolderGetter<Structure> context, ResourceKey<Structure> structure, int weight) {
        return new StructureSet.StructureSelectionEntry(context.getOrThrow(structure), weight);
    }

    private static RandomSpreadStructurePlacement createRandomLinearSpreadPlacement(int spread, int separation, int salt) {
        return new RandomSpreadStructurePlacement(spread, separation, RandomSpreadType.LINEAR, salt);
    }

    public static void structureSets() {
        GenerationsStructures.LOGGER.info("Registering Generations-Structures Structure Sets");
    }
}

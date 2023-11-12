package generations.gg.generations.structures.generationsstructures.worldgen.structureset;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

import java.util.Optional;

public class StructureSets {
    public static ResourceKey<StructureSet> LOOTBALL = create("lootball");
    public static ResourceKey<StructureSet> COMET = create("comet");
    public static ResourceKey<StructureSet> POKESHOPS = create("pokeshops");
    public static ResourceKey<StructureSet> SPIKE = create("spike");

    public static void bootstrap(BootstapContext<StructureSet> context) {
        register(context, COMET, GenerationsStructuresKeys.COMET,
                new RandomSpreadStructurePlacement(25, 15, RandomSpreadType.LINEAR, 1189082690));
    }

    private static void register(BootstapContext<StructureSet> context, ResourceKey<StructureSet> key, ResourceKey<Structure> structure, StructurePlacement placement) {
        System.out.println("Registering structure set " + key.location() + " with structure " + structure.location() + " and placement " + placement.getClass().getName());
        context.register(key, new StructureSet(context.lookup(Registries.STRUCTURE).getOrThrow(structure), placement));
    }


    private static ResourceKey<StructureSet> create(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, GenerationsStructures.id(name));
    }
}

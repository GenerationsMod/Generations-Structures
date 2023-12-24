package generations.gg.generations.structures.generationsstructures.village;

import com.mojang.datafixers.util.Pair;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to add structures to villages.
 * We do this by adding the structures to the existing village structure pool.
 * @author Joseph T. McQuigg
 */
public class PlaceInVillage {

    /**
     * Adds a building to a village structure pool.
     * @param serverRegistry The server registry.
     * @param poolRL The pool to add the building to.
     * @param processorList The processor list to use.
     * @param nbtPieceRL The nbt piece to add.
     * @param weight The weight of the building.
     */
    private static void addBuildingToPool(RegistryAccess.Frozen serverRegistry, ResourceLocation poolRL, ResourceKey<StructureProcessorList> processorList, ResourceLocation nbtPieceRL, int weight) {
        Registry<StructureTemplatePool> templatePoolRegistry = serverRegistry.registry(Registries.TEMPLATE_POOL).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = serverRegistry.registry(Registries.PROCESSOR_LIST).orElseThrow();
        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        Holder<StructureProcessorList> processorList1 = processorListRegistry.getHolderOrThrow(processorList);
        if (pool == null) return;

        SinglePoolElement piece = SinglePoolElement.legacy(nbtPieceRL.toString(), processorList1).apply(StructureTemplatePool.Projection.RIGID);

        for (int i = 0; i < weight; i++)
            pool.templates.add(piece);

        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.rawTemplates);
        listOfPieceEntries.add(new Pair<>(piece, weight));
        pool.rawTemplates = listOfPieceEntries;
    }

    /**
     * Adds structures to villages.
     * @param server The server to add the structures to.
     */
    public static void addStructuresToVillages(MinecraftServer server) {
        if (!GenerationsStructures.CONFIG.generation.AllowStructuresInVillages) return;
        GenerationsStructures.LOGGER.info("Adding structures to villages");
        RegistryAccess.Frozen serverRegistry = server.registryAccess();

        addBuildingToPool(serverRegistry, getPoolRL("plains/houses"), ProcessorLists.EMPTY, GenerationsStructures.id("gym/darkgym"), 250);
    }

    private static ResourceLocation getPoolRL(String poolName) {
        return new ResourceLocation("minecraft", "village/" + poolName);
    }
}

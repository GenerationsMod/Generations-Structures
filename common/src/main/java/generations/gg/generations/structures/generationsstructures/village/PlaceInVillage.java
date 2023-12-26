package generations.gg.generations.structures.generationsstructures.village;

import com.mojang.datafixers.util.Pair;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.config.Config;
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
     *
     * @param serverRegistry The server registry.
     * @param poolRL         The pool to add the building to.
     * @param processorList  The processor list to use.
     * @param nbtPieceRL     The nbt piece to add.
     * @param projection     The projection to use.
     * @param weight         The weight of the building.
     */
    private static void addBuildingToPool(RegistryAccess.Frozen serverRegistry, ResourceLocation poolRL, ResourceKey<StructureProcessorList> processorList, ResourceLocation nbtPieceRL, StructureTemplatePool.Projection projection, int weight) {
        Registry<StructureTemplatePool> templatePoolRegistry = serverRegistry.registry(Registries.TEMPLATE_POOL).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = serverRegistry.registry(Registries.PROCESSOR_LIST).orElseThrow();
        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        Holder<StructureProcessorList> processorList1 = processorListRegistry.getHolderOrThrow(processorList);
        if (pool == null) return;

        SinglePoolElement piece = SinglePoolElement.legacy(nbtPieceRL.toString(), processorList1).apply(projection);

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
        Config.VillageStructureGeneration config = GenerationsStructures.CONFIG.villageStructureGeneration;
        if (!config.AllowStructuresInVillages) return;
        GenerationsStructures.LOGGER.info("Adding structures to villages");
        RegistryAccess.Frozen serverRegistry = server.registryAccess();
        addBuildingToPool(serverRegistry, getPoolRL("village/plains/streets"), ProcessorLists.STREET_PLAINS, GenerationsStructures.id("streets/poke_street"), StructureTemplatePool.Projection.TERRAIN_MATCHING, 250);
        addBuildingToPool(serverRegistry, getPoolRL("village/desert/streets"), ProcessorLists.EMPTY, GenerationsStructures.id("streets/poke_street"), StructureTemplatePool.Projection.TERRAIN_MATCHING, 2);
        addBuildingToPool(serverRegistry, getPoolRL("village/savanna/streets"), ProcessorLists.STREET_SAVANNA, GenerationsStructures.id("streets/poke_street"), StructureTemplatePool.Projection.TERRAIN_MATCHING, 2);
        addBuildingToPool(serverRegistry, getPoolRL("village/snowy/streets"), ProcessorLists.STREET_SNOWY_OR_TAIGA, GenerationsStructures.id("streets/poke_street"), StructureTemplatePool.Projection.TERRAIN_MATCHING, 2);
        addBuildingToPool(serverRegistry, getPoolRL("village/taiga/streets"), ProcessorLists.STREET_SNOWY_OR_TAIGA, GenerationsStructures.id("streets/poke_street"), StructureTemplatePool.Projection.TERRAIN_MATCHING, 2);
    }

    private static ResourceLocation getPoolRL(String poolName) {
        return new ResourceLocation("minecraft", "village/" + poolName);
    }
}

package generations.gg.generations.structures.generationsstructures.worldgen.template_pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.GenerationsProcessorLists;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import generations.gg.generations.structures.generationsstructures.village.VanillaVillages;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.function.Function;

public class GenerationsTemplatePools {

    public static final ResourceKey<StructureTemplatePool> BEAST_BALLOON = create("loot_balloon/beast_balloon");
    public static final ResourceKey<StructureTemplatePool> GREAT_BALLOON = create("loot_balloon/great_balloon");
    public static final ResourceKey<StructureTemplatePool> MASTER_BALLOON = create("loot_balloon/master_balloon");
    public static final ResourceKey<StructureTemplatePool> MEOWTH_BALLOON = create("loot_balloon/meowth_balloon");
    public static final ResourceKey<StructureTemplatePool> POKE_BALLOON = create("loot_balloon/poke_balloon");
    public static final ResourceKey<StructureTemplatePool> ULTRA_BALLOON = create("loot_balloon/ultra_balloon");

    public static final ResourceKey<StructureTemplatePool> COMET = create("comet");
    public static final ResourceKey<StructureTemplatePool> SCARLET_POKECENTER = create("scarlet_pokecenter");
    public static final ResourceKey<StructureTemplatePool> SCARLET_POKECENTER_ANTENNA = create("scarlet_pokecenter_antenna");
    public static final ResourceKey<StructureTemplatePool> LARGE_POKECENTER = create("large_pokecenter");
    public static final ResourceKey<StructureTemplatePool> ISLANDS = create("islands");
    public static final ResourceKey<StructureTemplatePool> FROZEN_SHRINE = create("shrines/frozen_shrine");
    public static final ResourceKey<StructureTemplatePool> FIERY_SHRINE = create("shrines/fiery_shrine");
    public static final ResourceKey<StructureTemplatePool> STATIC_SHRINE = create("shrines/static_shrine");
    public static final ResourceKey<StructureTemplatePool> LUGIA_SHRINE = create("shrines/lugia_shrine");

    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKECENTER_STREETS = create("village/plains/streets/pokecenter");
    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKECENTER = create("village/plains/pokecenter");
    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKEMART_STREETS = create("village/plains/streets/pokemart");
    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKEMART = create("village/plains/pokemart");
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKECENTER_STREETS = create("village/desert/streets/pokecenter");
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKECENTER = create("village/desert/pokecenter");
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKEMART_STREETS = create("village/desert/streets/pokemart");
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKEMART = create("village/desert/pokemart");
    public static final ResourceKey<StructureTemplatePool> SAVANNA_VILLAGE_POKECENTER_STREETS = create("village/savanna/streets/pokecenter");
    public static final ResourceKey<StructureTemplatePool> SAVANNA_VILLAGE_POKECENTER = create("village/savanna/pokecenter");
    public static final ResourceKey<StructureTemplatePool> SAVANNA_VILLAGE_POKEMART_STREETS = create("village/savanna/streets/pokemart");
    public static final ResourceKey<StructureTemplatePool> SAVANNA_VILLAGE_POKEMART = create("village/savanna/pokemart");
    public static final ResourceKey<StructureTemplatePool> SNOWY_VILLAGE_POKECENTER_STREETS = create("village/snowy/streets/pokecenter");
    public static final ResourceKey<StructureTemplatePool> SNOWY_VILLAGE_POKECENTER = create("village/snowy/pokecenter");
    public static final ResourceKey<StructureTemplatePool> SNOWY_VILLAGE_POKEMART_STREETS = create("village/snowy/streets/pokemart");
    public static final ResourceKey<StructureTemplatePool> SNOWY_VILLAGE_POKEMART = create("village/snowy/pokemart");
    public static final ResourceKey<StructureTemplatePool> TAIGA_VILLAGE_POKECENTER_STREETS = create("village/taiga/streets/pokecenter");
    public static final ResourceKey<StructureTemplatePool> TAIGA_VILLAGE_POKECENTER = create("village/taiga/pokecenter");
    public static final ResourceKey<StructureTemplatePool> TAIGA_VILLAGE_POKEMART_STREETS = create("village/taiga/streets/pokemart");
    public static final ResourceKey<StructureTemplatePool> TAIGA_VILLAGE_POKEMART = create("village/taiga/pokemart");


    public static void bootstrap(BootstapContext<StructureTemplatePool> context) {
        register(context, BEAST_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.BEAST_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, GREAT_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.GREAT_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, MASTER_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.MASTER_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, MEOWTH_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.MEOWTH_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, POKE_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.POKE_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, ULTRA_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.ULTRA_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, COMET, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.COMET.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, SCARLET_POKECENTER, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.SCARLET_POKECENTER.location().toString(), getProcessor(context, GenerationsProcessorLists.SCARLET_POKECENTER_PROCESSOR_LIST)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, SCARLET_POKECENTER_ANTENNA, SCARLET_POKECENTER_ANTENNA, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.SCARLET_POKECENTER_ANTENNA.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, LARGE_POKECENTER, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.LARGE_POKECENTER.location().toString(), getProcessor(context, GenerationsProcessorLists.POKECENTER_PROCESSOR_LIST)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, ISLANDS, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.ISLANDS.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, FROZEN_SHRINE, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.FROZEN_SHRINE.location().toString(), getProcessor(context, GenerationsProcessorLists.FROZEN_SHRINE_PROCESSOR_LIST)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, FIERY_SHRINE, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.FIERY_SHRINE.location().toString(), getProcessor(context, GenerationsProcessorLists.FIERY_SHRINE_PROCESSOR_LIST)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, STATIC_SHRINE, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.STATIC_SHRINE.location().toString(), getProcessor(context, GenerationsProcessorLists.STATIC_SHRINE_PROCESSOR_LIST)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, LUGIA_SHRINE, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.LUGIA_SHRINE.location().toString(), getProcessor(context, GenerationsProcessorLists.LUGIA_SHRINE_PROCESSOR_LIST)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, PLAINS_VILLAGE_POKECENTER_STREETS, VanillaVillages.PLAINS.getVillagePool("streets"), ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKECENTER_STREET_CORNER_01.location().toString(), getProcessor(context, ProcessorLists.STREET_PLAINS)), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKECENTER_STREET_STRAIGHT_05.location().toString(), getProcessor(context, ProcessorLists.STREET_PLAINS)), 1)
        ), StructureTemplatePool.Projection.TERRAIN_MATCHING);

        register(context, PLAINS_VILLAGE_POKECENTER, PLAINS_VILLAGE_POKECENTER, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKECENTER_1.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKECENTER_2.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKECENTER_3.location().toString()), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, PLAINS_VILLAGE_POKEMART_STREETS, VanillaVillages.PLAINS.getVillagePool("streets"), ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKEMART_STREET_CORNER_01.location().toString(), getProcessor(context, ProcessorLists.STREET_PLAINS)), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKEMART_STREET_STRAIGHT_05.location().toString(), getProcessor(context, ProcessorLists.STREET_PLAINS)), 1)
        ), StructureTemplatePool.Projection.TERRAIN_MATCHING);

        register(context, PLAINS_VILLAGE_POKEMART, PLAINS_VILLAGE_POKEMART, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKEMART_1.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKEMART_2.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.PLAINS_POKEMART_3.location().toString()), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, DESERT_VILLAGE_POKEMART_STREETS, VanillaVillages.DESERT.getVillagePool("streets"), ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKEMART_STREET_CORNER_01.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKEMART_STREET_STRAIGHT_05.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.TERRAIN_MATCHING);

        register(context, DESERT_VILLAGE_POKECENTER_STREETS, VanillaVillages.DESERT.getVillagePool("streets"), ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKECENTER_STREET_CORNER_01.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKECENTER_STREET_STRAIGHT_05.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.TERRAIN_MATCHING);

        register(context, DESERT_VILLAGE_POKEMART, DESERT_VILLAGE_POKEMART, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKEMART_1.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKEMART_2.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKEMART_3.location().toString()), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, DESERT_VILLAGE_POKECENTER, DESERT_VILLAGE_POKECENTER, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKECENTER_1.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKECENTER_2.location().toString()), 1),
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.DESERT_POKECENTER_3.location().toString()), 1)
        ), StructureTemplatePool.Projection.RIGID);
    }

    private static ResourceKey<StructureTemplatePool> create(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, GenerationsStructures.id(name));
    }

    private static void register(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureTemplatePool> key, ResourceKey<StructureTemplatePool> fallback, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> rawTemplateFactories, StructureTemplatePool.Projection projection) {
        context.register(key, new StructureTemplatePool(context.lookup(Registries.TEMPLATE_POOL).getOrThrow(fallback), rawTemplateFactories, projection));
    }

    private static Holder.Reference<StructureProcessorList> getProcessor(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureProcessorList> processorList) {
        return context.lookup(Registries.PROCESSOR_LIST).getOrThrow(processorList);
    }
}

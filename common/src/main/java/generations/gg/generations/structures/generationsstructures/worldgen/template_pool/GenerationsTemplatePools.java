package generations.gg.generations.structures.generationsstructures.worldgen.template_pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.GenerationsProcessorLists;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructureSettings;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
import generations.gg.generations.structures.generationsstructures.village.VanillaVillages;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GenerationsTemplatePools {

    public static final Map<ResourceKey<StructureTemplatePool>, TemplatePoolFactory> TEMPLATE_POOL_FACTORIES = new Reference2ObjectOpenHashMap<>();

    public static final ResourceKey<StructureTemplatePool> BEAST_BALLOON = registerSimple("loot_balloon/beast", GenerationsStructureSettings.BEAST_BALLOON);
    public static final ResourceKey<StructureTemplatePool> GREAT_BALLOON = registerSimple("loot_balloon/great", GenerationsStructureSettings.GREAT_BALLOON);
    public static final ResourceKey<StructureTemplatePool> MASTER_BALLOON = registerSimple("loot_balloon/master", GenerationsStructureSettings.MASTER_BALLOON);
    public static final ResourceKey<StructureTemplatePool> MEOWTH_BALLOON = registerSimple("loot_balloon/meowth", GenerationsStructureSettings.MEOWTH_BALLOON, GenerationsProcessorLists.MEOWTH_BALLOON_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> POKE_BALLOON = registerSimple("loot_balloon/poke", GenerationsStructureSettings.POKE_BALLOON);
    public static final ResourceKey<StructureTemplatePool> ULTRA_BALLOON = registerSimple("loot_balloon/ultra", GenerationsStructureSettings.ULTRA_BALLOON);

    public static final ResourceKey<StructureTemplatePool> COMET = registerSimple("comet", GenerationsStructureSettings.COMET);
    public static final ResourceKey<StructureTemplatePool> SCARLET_POKECENTER = registerSimple("scarlet_pokecenter", GenerationsStructureSettings.SCARLET_POKECENTER, GenerationsProcessorLists.SCARLET_POKECENTER_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> SCARLET_POKECENTER_ANTENNA = registerSimple("scarlet_pokecenter_antenna", GenerationsStructuresKeys.SCARLET_POKECENTER_ANTENNA);
    public static final ResourceKey<StructureTemplatePool> LARGE_POKECENTER = registerSimple("large_pokecenter", GenerationsStructureSettings.LARGE_POKECENTER, GenerationsProcessorLists.POKECENTER_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> ISLANDS = registerSimple("islands", GenerationsStructureSettings.ISLANDS, GenerationsProcessorLists.ISLANDS_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> FROZEN_SHRINE = registerSimple("shrines/frozen", GenerationsStructureSettings.FROZEN_SHRINE, GenerationsProcessorLists.FROZEN_SHRINE_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> FIERY_SHRINE = registerSimple("shrines/fiery", GenerationsStructureSettings.FIERY_SHRINE, GenerationsProcessorLists.FIERY_SHRINE_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> STATIC_SHRINE = registerSimple("shrines/static", GenerationsStructureSettings.STATIC_SHRINE, GenerationsProcessorLists.STATIC_SHRINE_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> LUGIA_SHRINE = registerSimple("shrines/lugia", GenerationsStructureSettings.LUGIA_SHRINE, GenerationsProcessorLists.LUGIA_SHRINE_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> REGI_SHRINE = registerSimple("shrines/regi", GenerationsStructureSettings.REGI_SHRINE, GenerationsProcessorLists.REGI_SHRINE_PROCESSOR_LIST);

    public static final ResourceKey<StructureTemplatePool> CREATION_TRIO_SHRINE = registerSimple("shrines/creation_trio", GenerationsStructureSettings.CREATION_TRIO_SHRINE, GenerationsProcessorLists.CREATION_TRIO_SHRINE_PROCESSOR_LIST);
    public static final ResourceKey<StructureTemplatePool> GROUDON_SHRINE = registerSimple("shrines/groudon", GenerationsStructureSettings.GROUDON_SHRINE, GenerationsProcessorLists.GROUDON_SHRINE_PROCESSOR_LIST);

    private static final ResourceKey<StructureTemplatePool> CREATION_TRIO_TOP = register("shrines/creation_trio_top", context -> createTemplatePool(
            getPool(context, create("shrines/creation_trio_top")), ImmutableList.of(
                    createPoolElement(context, GenerationsStructuresKeys.CREATION_TRIO_TOP)
            ))
    );

    public static final ResourceKey<StructureTemplatePool> FORCES_OF_NATURE_SHRINE = registerSimple("shrines/forces_of_nature", GenerationsStructureSettings.FORCES_OF_NATURE_SHRINE, GenerationsProcessorLists.FORCES_OF_NATURE_SHRINE_PROCESSOR_LIST);

    public static final ResourceKey<StructureTemplatePool> TAPU_SHRINE = registerSimple("shrines/tapu", GenerationsStructureSettings.TAPU_SHRINE, GenerationsProcessorLists.TAPU_SHRINE_PROCESSOR_LIST);

    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKECENTER_STREETS = register("village/plains/streets/pokecenter", context -> createTemplatePool(getPool(context, VanillaVillages.PLAINS.getVillagePool("streets")), ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKECENTER_STREET_CORNER_01, ProcessorLists.STREET_PLAINS, 1),
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKECENTER_STREET_STRAIGHT_05, ProcessorLists.STREET_PLAINS, 1)
    ), StructureTemplatePool.Projection.TERRAIN_MATCHING));
    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKECENTER = register("village/plains/pokecenter", context -> createTemplatePool(context, ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKECENTER_1, 1),
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKECENTER_2, 1),
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKECENTER_3, 1)
    )));
    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKEMART_STREETS = register("village/plains/streets/pokemart", context -> createTemplatePool(getPool(context, VanillaVillages.PLAINS.getVillagePool("streets")), ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKEMART_STREET_CORNER_01, ProcessorLists.STREET_PLAINS, 1),
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKEMART_STREET_STRAIGHT_05, ProcessorLists.STREET_PLAINS, 1)
    ), StructureTemplatePool.Projection.TERRAIN_MATCHING));

    public static final ResourceKey<StructureTemplatePool> PLAINS_VILLAGE_POKEMART = register("village/plains/pokemart", context -> createTemplatePool(context, ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKEMART_1, 1),
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKEMART_2, 1),
            createPoolElement(context, GenerationsStructuresKeys.PLAINS_POKEMART_3, 1)
    )));
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKECENTER_STREETS = register("village/desert/streets/pokecenter", context -> createTemplatePool(getPool(context, VanillaVillages.DESERT.getVillagePool("streets")), ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKECENTER_STREET_CORNER_01, ProcessorLists.EMPTY, 1),
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKECENTER_STREET_STRAIGHT_05, ProcessorLists.EMPTY, 1)
    ), StructureTemplatePool.Projection.TERRAIN_MATCHING));
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKECENTER = register("village/desert/pokecenter", context -> createTemplatePool(context, ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKECENTER_1, 1),
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKECENTER_2, 1),
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKECENTER_3, 1)
    )));
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKEMART_STREETS = register("village/desert/streets/pokemart", context -> createTemplatePool(getPool(context, VanillaVillages.DESERT.getVillagePool("streets")), ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKEMART_STREET_CORNER_01, ProcessorLists.EMPTY, 1),
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKEMART_STREET_STRAIGHT_05, ProcessorLists.EMPTY, 1)
    ), StructureTemplatePool.Projection.TERRAIN_MATCHING));
    public static final ResourceKey<StructureTemplatePool> DESERT_VILLAGE_POKEMART = register("village/desert/pokemart", context -> createTemplatePool(context, ImmutableList.of(
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKEMART_1, 1),
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKEMART_2, 1),
            createPoolElement(context, GenerationsStructuresKeys.DESERT_POKEMART_3, 1)
    )));
    /*
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
    public static final ResourceKey<StructureTemplatePool> TAIGA_VILLAGE_POKEMART = create("village/taiga/pokemart"); */


    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> createPoolElement(BootstapContext<StructureTemplatePool> context, ResourceKey<Structure> structure) {
        return createPoolElement(context, structure, 1);
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> createPoolElement(BootstapContext<StructureTemplatePool> context, ResourceKey<Structure> structure, int weight) {
        return Pair.of(StructurePoolElement.single(structure.location().toString(), getEmptyProcessor(context)), weight);
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> createPoolElement(BootstapContext<StructureTemplatePool> context, ResourceKey<Structure> structure, ResourceKey<StructureProcessorList> processor) {
        return createPoolElement(context, structure, processor, 1);
    }

    private static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> createPoolElement(BootstapContext<StructureTemplatePool> context, ResourceKey<Structure> structure, ResourceKey<StructureProcessorList> processor, int weight) {
        return Pair.of(StructurePoolElement.single(structure.location().toString(), getProcessor(context, processor)), weight);
    }

    private static StructureTemplatePool createTemplatePool(Holder<StructureTemplatePool> fallback, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> rawTemplateFactories, StructureTemplatePool.Projection projection) {
        return new StructureTemplatePool(fallback, rawTemplateFactories, projection);
    }

    private static StructureTemplatePool createTemplatePool(BootstapContext<StructureTemplatePool> context, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> rawTemplateFactories) {
        return new StructureTemplatePool(getPool(context, Pools.EMPTY), rawTemplateFactories, StructureTemplatePool.Projection.RIGID);
    }

    private static StructureTemplatePool createTemplatePool(Holder<StructureTemplatePool> fallback, List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> rawTemplateFactories) {
        return new StructureTemplatePool(fallback, rawTemplateFactories, StructureTemplatePool.Projection.RIGID);
    }

    private static ResourceKey<StructureTemplatePool> registerSimple(String id, ResourceKey<Structure> structure, ResourceKey<StructureProcessorList> processor) {
        ResourceKey<StructureTemplatePool> templatePoolResourceKey = create(id);
        TEMPLATE_POOL_FACTORIES.put(templatePoolResourceKey, context -> createTemplatePool(context, ImmutableList.of(createPoolElement(context, structure, processor))));
        return templatePoolResourceKey;
    }

    private static ResourceKey<StructureTemplatePool> registerSimple(String id, ResourceKey<Structure> structure) {
        ResourceKey<StructureTemplatePool> templatePoolResourceKey = create(id);
        TEMPLATE_POOL_FACTORIES.put(templatePoolResourceKey, context -> createTemplatePool(context, ImmutableList.of(createPoolElement(context, structure))));
        return templatePoolResourceKey;
    }

    private static ResourceKey<StructureTemplatePool> register(String id, TemplatePoolFactory factory) {
        ResourceKey<StructureTemplatePool> templatePoolResourceKey = create(id);
        TEMPLATE_POOL_FACTORIES.put(templatePoolResourceKey, factory);
        return templatePoolResourceKey;
    }

    private static ResourceKey<StructureTemplatePool> create(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, GenerationsStructures.id(name));
    }

    private static Holder.Reference<StructureProcessorList> getProcessor(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureProcessorList> processorList) {
        return context.lookup(Registries.PROCESSOR_LIST).getOrThrow(processorList);
    }

    private static Holder.Reference<StructureTemplatePool> getPool(BootstapContext<StructureTemplatePool> context, ResourceKey<StructureTemplatePool> poolResourceKey) {
        return context.lookup(Registries.TEMPLATE_POOL).getOrThrow(poolResourceKey);
    }

    private static Holder.Reference<StructureProcessorList> getEmptyProcessor(BootstapContext<StructureTemplatePool> context) {
        return context.lookup(Registries.PROCESSOR_LIST).getOrThrow(ProcessorLists.EMPTY);
    }


    @FunctionalInterface
    public interface TemplatePoolFactory {
        StructureTemplatePool generate(BootstapContext<StructureTemplatePool> templatePoolFactoryContext);
    }

    public static void templatePools() {
        GenerationsStructures.LOGGER.info("Registering Generations-Structures Template Pools");
    }
}

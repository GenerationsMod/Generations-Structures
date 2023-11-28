package generations.gg.generations.structures.generationsstructures.worldgen.template_pool;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.structures.GenerationsStructuresKeys;
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
    public static final ResourceKey<StructureTemplatePool> NORMAL_BALLOON = create("loot_balloon/normal_balloon");
    public static final ResourceKey<StructureTemplatePool> ULTRA_BALLOON = create("loot_balloon/ultra_balloon");

    public static final ResourceKey<StructureTemplatePool> COMET = create("comet");
    public static final ResourceKey<StructureTemplatePool> SCARLET_POKESHOP = create("scarlet_pokeshop");
    public static final ResourceKey<StructureTemplatePool> SPIKE = create("spike");

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

        register(context, NORMAL_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.NORMAL_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, ULTRA_BALLOON, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.ULTRA_BALLOON.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);


        register(context, COMET, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.COMET.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.RIGID);

        register(context, SCARLET_POKESHOP, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.SCARLET_POKESHOP.location().toString()), 1)
        ), StructureTemplatePool.Projection.RIGID);


        register(context, SPIKE, Pools.EMPTY, ImmutableList.of(
                Pair.of(StructurePoolElement.single(GenerationsStructuresKeys.SPIKE.location().toString(), getProcessor(context, ProcessorLists.EMPTY)), 1)
        ), StructureTemplatePool.Projection.TERRAIN_MATCHING);
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

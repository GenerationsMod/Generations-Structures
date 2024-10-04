package generations.gg.generations.structures.generationsstructures.processors;

import biomesoplenty.api.block.BOPBlocks;
import com.google.common.collect.ImmutableList;
import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsBlocks;
import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsWood;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWood;
import tech.jt_dev.moreprocessors.processor.processors.CompatReplaceProcessor;
import tech.jt_dev.moreprocessors.processor.processors.CompatReplaceSameStateProcessor;
import tech.jt_dev.moreprocessors.processor.processors.RandomCompatProcessor;

import java.util.Map;

/**
 * This class is used to hold all the ProcessorLists
 * @see net.minecraft.data.worldgen.ProcessorLists
 * @author Joseph T. McQuigg
 */
public class GenerationsProcessorLists {

	public static final Map<ResourceKey<StructureProcessorList>, StructureProcessorListFactory> STRUCTURE_PROCESSOR_LIST_FACTORIES = new Reference2ObjectOpenHashMap<>();

	public static void init() {}

	//public static final ResourceKey<StructureProcessorList> GYM_PROCESSOR_LIST = create("gym_processor_list");
	public static final ResourceKey<StructureProcessorList> SCARLET_POKECENTER_PROCESSOR_LIST = register("scarlet_pokecenter", context ->  new StructureProcessorList(
			ImmutableList.of(
					new CompatReplaceSameStateProcessor(Blocks.BIRCH_TRAPDOOR, BWGWood.WITCH_HAZEL.trapdoor()), //TODO: Add BOP
					new CompatReplaceSameStateProcessor(GenerationsWood.GHOST_TRAPDOOR.get(), BWGWood.EBONY.trapdoor()
			))));
	public static final ResourceKey<StructureProcessorList> POKECENTER_PROCESSOR_LIST = register("pokecenter", context -> new StructureProcessorList(ImmutableList.of(
			//new CompatReplaceProcessor(GenerationsBlocks.MIRRORED_FLOOR_3_SET.getBaseBlock(), context.get(GenerationsStructures.INTEGRATION).getMirroredFloorReplacement()),
			new CompatReplaceProcessor(Blocks.POTTED_RED_TULIP, BOPBlocks.POTTED_ROSE),
			new CompatReplaceProcessor(Blocks.POTTED_PINK_TULIP, BOPBlocks.POTTED_VIOLET),
			new CompatReplaceProcessor(Blocks.BIRCH_LEAVES, BWGWood.FLOWERING_ORCHARD_LEAVES.get()),
			new CompatReplaceProcessor(Blocks.BIRCH_TRAPDOOR, BOPBlocks.FLOWERING_OAK_LEAVES)
	)));
	public static final ResourceKey<StructureProcessorList> FROZEN_SHRINE_PROCESSOR_LIST = register("shrines/frozen", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.GRAVEL, 0.75f), AlwaysTrueTest.INSTANCE, Blocks.SNOW_BLOCK.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.GRAVEL, 0.1f), AlwaysTrueTest.INSTANCE, Blocks.PACKED_ICE.defaultBlockState())
					)
			)
	)));

	public static final ResourceKey<StructureProcessorList> FIERY_SHRINE_PROCESSOR_LIST = register("shrines/fiery", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.CRIMSON_HYPHAE, 0.15f), AlwaysTrueTest.INSTANCE, Blocks.MAGMA_BLOCK.defaultBlockState())
					)
			)
	)));

	public static final ResourceKey<StructureProcessorList> STATIC_SHRINE_PROCESSOR_LIST = register("shrines/static", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.GRAVEL.defaultBlockState())
					)
			)
	)));

	/*
	public static void bootstrap(BootstapContext<StructureProcessorList> context) {
		StructureProcessors.init();
		register(context, SCARLET_POKECENTER_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new ScarletPokeCenterProcessor())));
		register(context, POKECENTER_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new PokeCenterProcessor())));
		register(context, FROZEN_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new FrozenShrineProcessor(),
						new RuleProcessor(
								ImmutableList.of(
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE_POWDER.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_WOOL.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_CONCRETE_POWDER, 0.15F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_WOOL.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_CONCRETE_POWDER, 0.3F), AlwaysTrueTest.INSTANCE, Blocks.SNOW_BLOCK.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_CONCRETE_POWDER, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_CONCRETE, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.SNOW_BLOCK.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_CONCRETE, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE_POWDER.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_CONCRETE, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_WOOL.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_WOOL, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.SNOW_BLOCK.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_WOOL, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE_POWDER.defaultBlockState()),
										new ProcessorRule(
												new RandomBlockMatchTest(Blocks.WHITE_WOOL, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE.defaultBlockState())
								)
						)
				)));
		register(context, FIERY_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new FieryShrineRandomizerProcessor(), new FieryShrineProcessor())));
		register(context, STATIC_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new StaticShrineRandomizerProcessor(), new StaticShrineProcessor())));
		register(context, LUGIA_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new LugiaShrineRandomizerProcessor())));
	}

	 */

	private static StructureProcessorList createProcessorList(ProcessorRule... processors) {
		return new StructureProcessorList(ImmutableList.of(new RuleProcessor(ImmutableList.copyOf(processors))));
	}

	private static ResourceKey<StructureProcessorList> register(String id, StructureProcessorListFactory factory) {
		ResourceKey<StructureProcessorList> structureProcessorListResourceKey = create(id + "_processor_list");
		STRUCTURE_PROCESSOR_LIST_FACTORIES.put(structureProcessorListResourceKey, factory);
		return structureProcessorListResourceKey;
	}

	/**
	 * Creates a ResourceKey for the ProcessorList.
	 * @param name of the structure set or directory with name.
	 * @return ResourceKey<StructureProcessorList>
	 */
	private static ResourceKey<StructureProcessorList> create(String name) {
		return ResourceKey.create(Registries.PROCESSOR_LIST, GenerationsStructures.id(name));
	}

	@FunctionalInterface
	public interface StructureProcessorListFactory  {
		StructureProcessorList generate(HolderGetter<StructureProcessorList> structureProcessorListHolderGetter);
	}
}

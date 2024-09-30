package generations.gg.generations.structures.generationsstructures.processors;

import com.google.common.collect.ImmutableList;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

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
	public static final ResourceKey<StructureProcessorList> SCARLET_POKECENTER_PROCESSOR_LIST = create("scarlet_pokecenter_processor_list");
	public static final ResourceKey<StructureProcessorList> POKECENTER_PROCESSOR_LIST = create("pokecenter_processor_list");
	public static final ResourceKey<StructureProcessorList> FROZEN_SHRINE_PROCESSOR_LIST = create("shrines/frozen_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> FIERY_SHRINE_PROCESSOR_LIST = create("shrines/fiery_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> STATIC_SHRINE_PROCESSOR_LIST = create("shrines/static_shrine_processor_list");

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

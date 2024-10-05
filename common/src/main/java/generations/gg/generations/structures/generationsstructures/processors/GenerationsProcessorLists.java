package generations.gg.generations.structures.generationsstructures.processors;

import biomesoplenty.api.block.BOPBlocks;
import com.google.common.collect.ImmutableList;
import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsWood;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.potionstudios.biomeswevegone.world.level.block.BWGBlocks;
import net.potionstudios.biomeswevegone.world.level.block.wood.BWGWood;
import tech.jt_dev.moreprocessors.processor.processors.*;
import tech.jt_dev.moreprocessors.processor.processors.rules.CompatProcessorRule;
import tech.jt_dev.moreprocessors.processor.processors.rules.SameStateCompatProcessorRule;
import tech.jt_dev.moreprocessors.processor.processors.rules.SameStateProcessorRule;

import java.util.Map;

/**
 * This class is used to hold all the ProcessorLists
 * @see net.minecraft.data.worldgen.ProcessorLists
 * @author Joseph T. McQuigg
 */
public class GenerationsProcessorLists {

	public static final Map<ResourceKey<StructureProcessorList>, StructureProcessorListFactory> STRUCTURE_PROCESSOR_LIST_FACTORIES = new Reference2ObjectOpenHashMap<>();

	public static void init() {}

	public static final ResourceKey<StructureProcessorList> SCARLET_POKECENTER_PROCESSOR_LIST = register("scarlet_pokecenter", context ->  new StructureProcessorList(ImmutableList.of(
			new SameStateCompatRuleProcessor(
					ImmutableList.of(
							new SameStateCompatProcessorRule(new BlockMatchTest(Blocks.BIRCH_TRAPDOOR), AlwaysTrueTest.INSTANCE, BWGWood.WITCH_HAZEL.trapdoor()),
							new SameStateCompatProcessorRule(new BlockMatchTest(GenerationsWood.GHOST_TRAPDOOR.get()), AlwaysTrueTest.INSTANCE, BWGWood.EBONY.trapdoor()),
							new SameStateCompatProcessorRule(new BlockMatchTest(GenerationsWood.GHOST_TRAPDOOR.get()), AlwaysTrueTest.INSTANCE, BOPBlocks.HELLBARK_TRAPDOOR)
					)
			)
	)));

	public static final ResourceKey<StructureProcessorList> POKECENTER_PROCESSOR_LIST = register("pokecenter", context -> new StructureProcessorList(ImmutableList.of(
			new CompatRuleProcessor(
					ImmutableList.of(
							new CompatProcessorRule(new BlockMatchTest(Blocks.POTTED_RED_TULIP), AlwaysTrueTest.INSTANCE, BOPBlocks.POTTED_ROSE),
							new CompatProcessorRule(new BlockMatchTest(Blocks.POTTED_PINK_TULIP), AlwaysTrueTest.INSTANCE, BOPBlocks.POTTED_VIOLET),
							new CompatProcessorRule(new BlockMatchTest(Blocks.BIRCH_LEAVES), AlwaysTrueTest.INSTANCE, BWGWood.FLOWERING_ORCHARD_LEAVES.get()),
							new CompatProcessorRule(new BlockMatchTest(Blocks.BIRCH_LEAVES), AlwaysTrueTest.INSTANCE, BOPBlocks.FLOWERING_OAK_LEAVES)
					)
			)
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

	public static final ResourceKey<StructureProcessorList> LUGIA_SHRINE_PROCESSOR_LIST = register("shrines/lugia", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.1f), AlwaysTrueTest.INSTANCE, Blocks.COBBLESTONE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.15f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.15f), AlwaysTrueTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.defaultBlockState())
					)
			),
			new SameStateRuleProcessor(
					ImmutableList.of(
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_SLAB, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.COBBLESTONE_SLAB),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_SLAB, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_SLAB),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_STAIRS, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.COBBLESTONE_STAIRS),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_STAIRS, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_STAIRS)
					)
			),
			new CompatRuleProcessor(
					ImmutableList.of(
							new CompatProcessorRule(new RandomBlockMatchTest(Blocks.MOSSY_STONE_BRICKS, 0.25f), AlwaysTrueTest.INSTANCE, BWGBlocks.MOSSY_STONE_SET.getBase())
					)
			)
	)));

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

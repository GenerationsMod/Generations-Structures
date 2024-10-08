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
import net.minecraft.world.level.block.LeavesBlock;
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

	public static final ResourceKey<StructureProcessorList> REGI_SHRINE_PROCESSOR_LIST = register("shrines/regi", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.CALCITE, 0.5f), AlwaysTrueTest.INSTANCE, GenerationsBlocks.BLEACH_STONE_SET.getBaseBlock().defaultBlockState())
					)
			),
			new SameStateRuleProcessor(
					ImmutableList.of(
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.DIORITE_WALL, 0.5f), AlwaysTrueTest.INSTANCE, GenerationsBlocks.BLEACH_STONE_SET.getWall())
					)
			)
	)));

	public static final ResourceKey<StructureProcessorList> CREATION_TRIO_SHRINE_PROCESSOR_LIST = register("shrines/creation_trio", context -> new StructureProcessorList(ImmutableList.of(
		new RuleProcessor(
				ImmutableList.of(
						new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.35f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_ANDESITE.defaultBlockState()),
						new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState()
				)
		)),
			new SameStateRuleProcessor(
					ImmutableList.of(
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_STAIRS, 0.35f), AlwaysTrueTest.INSTANCE, Blocks.POLISHED_ANDESITE_STAIRS),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_STAIRS, 0.20f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_STAIRS)
					)
			))));

	public static final ResourceKey<StructureProcessorList> FORCES_OF_NATURE_SHRINE_PROCESSOR_LIST = register("shrines/forces_of_nature", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.4f), AlwaysTrueTest.INSTANCE, Blocks.WHITE_WOOL.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.WHITE_STAINED_GLASS.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.15f), AlwaysTrueTest.INSTANCE, Blocks.WHITE_CONCRETE_POWDER.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SNOW_BLOCK, 0.06f), AlwaysTrueTest.INSTANCE, Blocks.DIORITE.defaultBlockState())
					)
			),
			new CompatRuleProcessor(
					ImmutableList.of(
							new CompatProcessorRule(new RandomBlockMatchTest(Blocks.ALLIUM, 0.5f), AlwaysTrueTest.INSTANCE, BWGBlocks.PINK_ALLIUM.getBlock()),
							new CompatProcessorRule(new RandomBlockMatchTest(Blocks.ALLIUM, 0.5f), AlwaysTrueTest.INSTANCE, BWGBlocks.WHITE_ALLIUM.getBlock()),
							new CompatProcessorRule(new RandomBlockMatchTest(Blocks.ALLIUM, 0.5f), AlwaysTrueTest.INSTANCE, BWGBlocks.ALPINE_BELLFLOWER.getBlock())
					)
			),
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.ALLIUM, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.BLUE_ORCHID.defaultBlockState())
					)
			)
	)));

	public static final ResourceKey<StructureProcessorList> ISLANDS_PROCESSOR_LIST = register("islands", context -> new StructureProcessorList(ImmutableList.of(
			new RuleProcessor(
					ImmutableList.of(
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE, 0.33f), AlwaysTrueTest.INSTANCE, Blocks.ANDESITE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE, 0.33f), AlwaysTrueTest.INSTANCE, Blocks.COBBLESTONE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE, 0.1f), AlwaysTrueTest.INSTANCE, Blocks.COAL_ORE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLED_DEEPSLATE, 0.33f), AlwaysTrueTest.INSTANCE, Blocks.DEEPSLATE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SMOOTH_SANDSTONE, 0.33f), AlwaysTrueTest.INSTANCE, Blocks.SANDSTONE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.SMOOTH_SANDSTONE, 0.33f), AlwaysTrueTest.INSTANCE, Blocks.CUT_SANDSTONE.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.AZALEA_LEAVES, 0.33f), AlwaysTrueTest.INSTANCE, Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true)),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.AZALEA_LEAVES, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.JUNGLE_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true)),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.GRASS_BLOCK, 0.25f), AlwaysTrueTest.INSTANCE, Blocks.MOSS_BLOCK.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.GRASS_BLOCK, 0.2f), AlwaysTrueTest.INSTANCE, Blocks.GREEN_CONCRETE_POWDER.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.GRASS_BLOCK, 0.1f), AlwaysTrueTest.INSTANCE, Blocks.GREEN_TERRACOTTA.defaultBlockState()),
							new ProcessorRule(new RandomBlockMatchTest(Blocks.AZALEA, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.FLOWERING_AZALEA.defaultBlockState())
					)
			),
			new PlaceOnTopProcessor(Blocks.GRASS_BLOCK, Blocks.GREEN_CARPET, 0.1f, true),
			new PlaceOnTopProcessor(Blocks.GRASS_BLOCK, Blocks.MOSS_CARPET, 0.1f, true),
			new PlaceOnTopProcessor(Blocks.GRASS_BLOCK, Blocks.ALLIUM, 0.05f, true),
			new SameStateRuleProcessor(
					ImmutableList.of(
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_WALL, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.ANDESITE_WALL),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_SLAB, 0.4f), AlwaysTrueTest.INSTANCE, Blocks.ANDESITE_SLAB),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.STONE_SLAB, 0.1f), AlwaysTrueTest.INSTANCE, Blocks.COBBLESTONE_SLAB),
							new SameStateProcessorRule(new RandomBlockMatchTest(Blocks.SMOOTH_SANDSTONE_SLAB, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.SANDSTONE_SLAB)
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

	public static void processorLists() {
		GenerationsStructures.LOGGER.info("Registering Generations-Structures Processor Lists");
	}
}

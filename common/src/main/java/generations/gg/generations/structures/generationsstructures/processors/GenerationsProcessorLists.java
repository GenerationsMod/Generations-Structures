package generations.gg.generations.structures.generationsstructures.processors;

import com.google.common.collect.ImmutableList;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.burnedTower.BurnedTowerShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.creationTrio.CreationTrioShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery.FieryShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery.FieryShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.forcesOfNature.ForcesOfNatureShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.frozen.FrozenShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.GymProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.PokeCenterProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.ScarletPokeCenterProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.groudon.GroudonShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.kyogre.KyogreShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.lugia.LugiaShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.lunarDuo.LunarDuoShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.regi.RegiShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine.StaticShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine.StaticShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.tapu.TapuShrineRandomizerProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

/**
 * This class is used to hold all the ProcessorLists
 * @see net.minecraft.data.worldgen.ProcessorLists
 * @author Joseph T. McQuigg
 */
public class GenerationsProcessorLists {
	public static void init() {}

	public static final ResourceKey<StructureProcessorList> GYM_PROCESSOR_LIST = create("gym_processor_list");
	public static final ResourceKey<StructureProcessorList> SCARLET_POKECENTER_PROCESSOR_LIST = create("scarlet_pokecenter_processor_list");
	public static final ResourceKey<StructureProcessorList> POKECENTER_PROCESSOR_LIST = create("pokecenter_processor_list");
	public static final ResourceKey<StructureProcessorList> FROZEN_SHRINE_PROCESSOR_LIST = create("shrines/frozen_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> FIERY_SHRINE_PROCESSOR_LIST = create("shrines/fiery_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> STATIC_SHRINE_PROCESSOR_LIST = create("shrines/static_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> LUGIA_SHRINE_PROCESSOR_LIST = create("shrines/lugia_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> BURNED_TOWER_SHRINE_PROCESSOR_LIST = create("shrines/burned_tower_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> CREATION_TRIO_SHRINE_PROCESSOR_LIST = create("shrines/creation_trio_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> FORCES_OF_NATURE_SHRINE_PROCESSOR_LIST = create("shrines/forces_of_nature_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> GROUDON_SHRINE_PROCESSOR_LIST = create("shrines/groudon_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> KYOGRE_SHRINE_PROCESSOR_LIST = create("shrines/kyogre_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> REGI_SHRINE_PROCESSOR_LIST = create("shrines/regi_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> TAPU_SHRINE_PROCESSOR_LIST = create("shrines/tapu_shrine_processor_list");
	public static final ResourceKey<StructureProcessorList> LUNAR_DUO_SHRINE_PROCESSOR_LIST = create("shrines/lunar_duo_shrine_processor_list");


	/**
	 * This method is used to bootstrap the processorlists.
	 * @param context The bootstrap context
	 */
	public static void bootstrap(BootstapContext<StructureProcessorList> context) {
		StructureProcessors.init();
		register(context, SCARLET_POKECENTER_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new ScarletPokeCenterProcessor())));
		register(context, GYM_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new GymProcessor())));
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
		register(context, BURNED_TOWER_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new BurnedTowerShrineRandomizerProcessor())));
		register(context, CREATION_TRIO_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new CreationTrioShrineRandomizerProcessor())));
		register(context, LUNAR_DUO_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new LunarDuoShrineRandomizerProcessor())));
		register(context, FORCES_OF_NATURE_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new ForcesOfNatureShrineRandomizerProcessor())));
		register(context, GROUDON_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new GroudonShrineRandomizerProcessor())));
		register(context, KYOGRE_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new KyogreShrineRandomizerProcessor())));
		register(context, REGI_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new RegiShrineRandomizerProcessor())));
		register(context, TAPU_SHRINE_PROCESSOR_LIST, new StructureProcessorList(ImmutableList.of(new TapuShrineRandomizerProcessor())));

	}

	/**
	 * Registers a ProcessorList with the given key and StructureProcessorList.
	 * @param context The bootstrap context
	 * @param key The key for the ProcessorList
	 * @param structureProcessorList The StructureProcessorList to register
	 */
	private static void register(BootstapContext<StructureProcessorList> context, ResourceKey<StructureProcessorList> key, StructureProcessorList structureProcessorList) {
		context.register(key, structureProcessorList);
	}

	/**
	 * Creates a ResourceKey for the ProcessorList.
	 * @param name of the structure set or directory with name.
	 * @return ResourceKey<StructureProcessorList>
	 */
	private static ResourceKey<StructureProcessorList> create(String name) {
		return ResourceKey.create(Registries.PROCESSOR_LIST, GenerationsStructures.id(name));
	}
}

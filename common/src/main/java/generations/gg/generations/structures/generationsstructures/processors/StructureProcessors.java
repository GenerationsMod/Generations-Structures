package generations.gg.generations.structures.generationsstructures.processors;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery.FieryShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.fiery.FieryShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.frozen.FrozenShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.GymProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.PokeCenterProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.ScarletPokeShopProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.lugia.LugiaShrineRandomizerProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine.StaticShrineProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.shrines.staticShrine.StaticShrineRandomizerProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

/**
 * Structure processor types for Generations Structures
 * @see StructureProcessorType
 * @author J.T. McQuigg (JT122406)
 */
public class StructureProcessors {
    public static final StructureProcessorType<ScarletPokeShopProcessor> SCARLET_POKESHOP_PROCESSOR = () -> ScarletPokeShopProcessor.CODEC;
    public static final StructureProcessorType<GymProcessor> GYM_PROCESSOR = () -> GymProcessor.CODEC;
    public static final StructureProcessorType<PokeCenterProcessor> POKECENTER_PROCESSOR = () -> PokeCenterProcessor.CODEC;
    public static final StructureProcessorType<FrozenShrineProcessor> FROZEN_SHRINE_PROCESSOR = () -> FrozenShrineProcessor.CODEC;
    public static final StructureProcessorType<FieryShrineRandomizerProcessor> FIERY_SHRINE_RANDOMIZER_PROCESSOR = () -> FieryShrineRandomizerProcessor.CODEC;
    public static final StructureProcessorType<FieryShrineProcessor> FIERY_SHRINE_PROCESSOR = () -> FieryShrineProcessor.CODEC;
    public static final StructureProcessorType<StaticShrineRandomizerProcessor> STATIC_SHRINE_RANDOMIZER_PROCESSOR = () -> StaticShrineRandomizerProcessor.CODEC;
    public static final StructureProcessorType<StaticShrineProcessor> STATIC_SHRINE_PROCESSOR = () -> StaticShrineProcessor.CODEC;
    public static final StructureProcessorType<LugiaShrineRandomizerProcessor> LUGIA_SHRINE_RANDOMIZER_PROCESSOR = () -> LugiaShrineRandomizerProcessor.CODEC;


    /**
     * Registers all custom structure processor types.
     */
    public static void init() {
        GenerationsStructures.LOGGER.info("Registering Structure Processors");
        register("scarlet_pokeshop_processor", SCARLET_POKESHOP_PROCESSOR);
        register("gym_processor", GYM_PROCESSOR);
        register("pokecenter_processor", POKECENTER_PROCESSOR);
        register("shrines/frozen_shrine_processor", FROZEN_SHRINE_PROCESSOR);
        register("shrines/fiery_shrine_randomizer_processor", FIERY_SHRINE_RANDOMIZER_PROCESSOR);
        register("shrines/fiery_shrine_processor", FIERY_SHRINE_PROCESSOR);
        register("shrines/static_shrine_randomizer_processor", STATIC_SHRINE_RANDOMIZER_PROCESSOR);
        register("shrines/static_shrine_processor", STATIC_SHRINE_PROCESSOR);
        register("shrines/lugia_shrine_randomizer_processor", LUGIA_SHRINE_RANDOMIZER_PROCESSOR);
    }

    /**
     * Utility method for registering custom structure processor types.
     */
    private static void register(String name, StructureProcessorType<?> processorType) {
        Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, GenerationsStructures.id(name), processorType);
    }
}

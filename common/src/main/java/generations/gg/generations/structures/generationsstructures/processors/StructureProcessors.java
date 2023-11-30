package generations.gg.generations.structures.generationsstructures.processors;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.GymProcessor;
import generations.gg.generations.structures.generationsstructures.processors.structure_processors.ScarletPokeShopProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

/**
 * Structure processor types for Generations Structures
 * @see StructureProcessorType
 * @author J.T. McQuigg (JT122406)
 */
public class StructureProcessors {
    public static StructureProcessorType<ScarletPokeShopProcessor> SCARLET_POKESHOP_PROCESSOR = () -> ScarletPokeShopProcessor.CODEC;
    public static StructureProcessorType<GymProcessor> GYM_PROCESSOR = () -> GymProcessor.CODEC;


    /**
     * Registers all custom structure processor types.
     */
    public static void init() {
        register("scarlet_pokeshop_processor", SCARLET_POKESHOP_PROCESSOR);
        register("gym_processor", GYM_PROCESSOR);
    }

    /**
     * Utility method for registering custom structure processor types.
     */
    private static void register(String name, StructureProcessorType<?> processorType) {
        Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, GenerationsStructures.id(name), processorType);
    }
}

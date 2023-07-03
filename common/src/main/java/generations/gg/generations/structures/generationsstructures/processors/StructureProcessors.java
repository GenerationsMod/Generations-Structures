package generations.gg.generations.structures.generationsstructures.processors;

import generations.gg.generations.core.generationscore.GenerationsCore;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
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


    /**
     * Registers all custom structure processor types.
     */
    public static void init() {
        if (GenerationsStructures.CONFIG.integration.AllowIntegrations && GenerationsStructures.INTEGRATION.getModId() != null)
            register("scarlet_pokeshop_processor", SCARLET_POKESHOP_PROCESSOR);
    }

    /**
     * Utility method for registering custom structure processor types.
     */
    private static void register(String name, StructureProcessorType<?> processorType) {
        Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, GenerationsCore.id(name), processorType);
    }
}

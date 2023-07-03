package generations.gg.generations.structures.generationsstructures;

import generations.gg.generations.core.generationscore.config.ConfigLoader;
import generations.gg.generations.structures.generationsstructures.config.Config;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraft.resources.ResourceLocation;

/**
 * The main class for the Generations-Structures mod.
 * @author J.T. McQuigg (JT122406)
 */
public class GenerationsStructures {

    /** generations_structures modid */
    public static final String MOD_ID = "generations_structures";

    /** generations_structures config */
    public static Config CONFIG;

    public static Integration INTEGRATION;
    public static void init(Integration integration) {
        CONFIG = ConfigLoader.loaderConfig(Config.class, "structures", "config");
        INTEGRATION = integration;
    }

    /**
     * Creates a {@link ResourceLocation} with the Generations-Core Mod id.
     */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}

package generations.gg.generations.structures.generationsstructures;
import generations.gg.generations.core.generationscore.common.config.ConfigLoader;
import generations.gg.generations.structures.generationsstructures.config.Config;
import generations.gg.generations.structures.generationsstructures.processors.GenerationsProcessorLists;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The main class for the Generations-Structures mod.
 * @author J.T. McQuigg (JT122406)
 */
public class GenerationsStructures {

    /** generations_structures modid */
    public static final String MOD_ID = "generations_structures";

    /** generations_structures logger */
    public static final Logger LOGGER = LogManager.getLogger();

    /** generations_structures config */
    public static Config CONFIG;

    /**
     * Initializes the Generations-Structures mod.
     */
    public static void init() {
        CONFIG = ConfigLoader.loadConfig(Config.class, "structures", "config");
        GenerationsProcessorLists.init();
    }

    /**
     * Creates a {@link ResourceLocation} with the Generations-Structures Mod id.
     * @param path The path of the resource location.
     */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}

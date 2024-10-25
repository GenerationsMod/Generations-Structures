package generations.gg.generations.structures.generationsstructures.forge;

import generations.gg.generations.core.generationscore.common.config.ConfigLoader;
import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

/**
 * Forge initializer for Generations Structures
 * @see Mod
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        ConfigLoader.setConfigDirectory(FMLPaths.CONFIGDIR.get());
        GenerationsStructures.init();
    }
}

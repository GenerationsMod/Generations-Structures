package generations.gg.generations.modulename.generationsmodulename.fabric;


import generations.gg.generations.modulename.generationsmodulename.GenerationsModuleNameExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class GenerationsModuleNameExpectPlatformImpl {
    /**
     * This is our actual method to {@link GenerationsModuleNameExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}

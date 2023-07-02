package generations.gg.generations.modulename.generationsmodulename.forge;

import generations.gg.generations.modulename.generationsmodulename.GenerationsModuleNameExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class GenerationsModuleNameExpectPlatformImpl {
    /**
     * This is our actual method to {@link GenerationsModuleNameExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}

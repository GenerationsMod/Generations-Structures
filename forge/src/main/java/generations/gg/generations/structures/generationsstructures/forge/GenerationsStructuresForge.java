package generations.gg.generations.structures.generationsstructures.forge;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.forge.integration.BOP;
import generations.gg.generations.structures.generationsstructures.forge.integration.BYGBOP;
import generations.gg.generations.structures.generationsstructures.forge.integration.BYGForge;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        Integration integration;
        if (ModList.get().isLoaded("biomesoplenty") && ModList.get().isLoaded("byg")) integration = new BYGBOP();
        else if (ModList.get().isLoaded("biomesoplenty")) integration = new BOP();
        else if (ModList.get().isLoaded("byg")) integration = new BYGForge();
        else integration = new Default();
        GenerationsStructures.init(integration);
    }
}

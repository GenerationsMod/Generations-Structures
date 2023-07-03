package generations.gg.generations.structures.generationsstructures.forge;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.byg.BYG;
import generations.gg.generations.structures.generationsstructures.forge.integration.BOP;
import generations.gg.generations.structures.generationsstructures.forge.integration.BYGBOP;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        Integration integration;
        if (ModList.get().isLoaded("biomesoplenty") && ModList.get().isLoaded("byg")) integration = new BYGBOP();
        else if (ModList.get().isLoaded("biomesoplenty")) integration = new BOP();
        else if (ModList.get().isLoaded("byg")) integration = new BYG();
        else integration = new Default();
        GenerationsStructures.init(integration);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    /**
     * Queues all custom structure processor types for safe registration.
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(StructureProcessors::init);
    }
}

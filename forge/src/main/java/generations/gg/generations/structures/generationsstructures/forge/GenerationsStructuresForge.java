package generations.gg.generations.structures.generationsstructures.forge;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.forge.events.LifeCycleEvents;
import generations.gg.generations.structures.generationsstructures.forge.integration.BOP;
import generations.gg.generations.structures.generationsstructures.integration.Default;
import generations.gg.generations.structures.generationsstructures.integration.Integration;
import generations.gg.generations.structures.generationsstructures.processors.StructureProcessors;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Forge initializer for Generations Structures
 * @see Mod
 * @see GenerationsStructures
 * @author J.T. McQuigg (JT122406)
 */
@Mod(GenerationsStructures.MOD_ID)
public class GenerationsStructuresForge {
    public GenerationsStructuresForge() {
        Integration integration;
        if (ModList.get().isLoaded(biomesoplenty.core.BiomesOPlenty.MOD_ID)) integration = new BOP();
        else integration = new Default();
        GenerationsStructures.init(integration);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
        //MinecraftForge.EVENT_BUS.addListener(LifeCycleEvents::aboutToStartEvent);
    }

    /**
     * Queues all custom structure processor types for safe registration.
     * @see FMLCommonSetupEvent
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(StructureProcessors::init);
    }
}

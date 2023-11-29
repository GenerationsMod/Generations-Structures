package generations.gg.generations.structures.generationsstructures.forge.events;

import generations.gg.generations.structures.generationsstructures.GenerationsStructures;
import generations.gg.generations.structures.generationsstructures.village.PlaceInVillage;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GenerationsStructures.MOD_ID)
public class LifeCycleEvents {
	/**
	 * Adds all custom structures to villages.
	 */
	@SubscribeEvent
	public static void aboutToStartEvent(final ServerAboutToStartEvent event) {
		PlaceInVillage.addStructuresToVillages(event.getServer());
	}
}

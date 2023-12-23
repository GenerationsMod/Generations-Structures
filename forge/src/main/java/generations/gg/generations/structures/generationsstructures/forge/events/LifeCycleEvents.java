package generations.gg.generations.structures.generationsstructures.forge.events;

import generations.gg.generations.structures.generationsstructures.village.PlaceInVillage;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

public class LifeCycleEvents {
	/**
	 * Adds all custom structures to villages.
	 */
	public static void aboutToStartEvent(final ServerAboutToStartEvent event) {
		PlaceInVillage.addStructuresToVillages(event.getServer());
	}
}

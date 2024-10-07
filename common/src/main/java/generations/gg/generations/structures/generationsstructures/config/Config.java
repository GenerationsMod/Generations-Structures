package generations.gg.generations.structures.generationsstructures.config;

/**
 * Config class for Generations Structures
 * @author J.T. McQuigg (JT122406)
 */
public class Config {
    public VillageStructureGeneration villageStructureGeneration = new VillageStructureGeneration();

    public static class VillageStructureGeneration {
        public boolean AllowStructuresInVillages = true;
    }
}

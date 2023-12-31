package generations.gg.generations.structures.generationsstructures.config;

/**
 * Config class for Generations Structures
 * @author J.T. McQuigg (JT122406)
 */
public class Config {
    public Integration integration = new Integration();

    public static class Integration {
        public boolean AllowIntegrations = true;
        public boolean AllowBYGIntegration = true;
        public boolean AllowBiomesOPlentyIntegration = true;
    }

    public VillageStructureGeneration villageStructureGeneration = new VillageStructureGeneration();

    public static class VillageStructureGeneration {
        public boolean AllowStructuresInVillages = true;
        public int PokeCenterWeight = 200;
        public boolean randomizeVendingMachineColors = true;
    }

}

package generations.gg.generations.structures.generationsstructures.config;

/**
 * Config class for Generations Structures
 * @author J.T. McQuigg (JT122406)
 */
public class Config {
    public Integration integration = new Integration();

    public static class Integration {
        public boolean AllowIntegrations = true;
        public boolean AllowBiomesOPlentyIntegration = true;
        public boolean AllowBiomesWeveGoneIntegration = true;
    }

    public VillageStructureGeneration villageStructureGeneration = new VillageStructureGeneration();

    public static class VillageStructureGeneration {
        public boolean AllowStructuresInVillages = true;
        public boolean randomizeVendingMachineColors = true;
    }

    public Randomization randomization = new Randomization();

    public static class Randomization {
        public boolean randomizeFieryShrineBlocks = true;
        public boolean randomizeStaticShrineBlocks = true;
        public boolean randomizeLugiaShrineBlocks = true;
    }

}

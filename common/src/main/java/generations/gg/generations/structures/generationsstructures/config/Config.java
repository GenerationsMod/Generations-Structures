package generations.gg.generations.structures.generationsstructures.config;

public class Config {
    public Integration integration = new Integration();

    public static class Integration {
        public boolean AllowIntegrations = true;
        public boolean AllowBYGIntegration = true;
        public boolean AllowBiomesOPlentyIntegration = true;
    }

}

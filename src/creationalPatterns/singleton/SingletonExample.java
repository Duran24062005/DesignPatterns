public class SingletonExample {

    static class Configuration {
        private static final Configuration INSTANCE = new Configuration();
        private String environment = "development";

        private Configuration() { }

        static Configuration getInstance() {
            return INSTANCE;
        }

        void setEnvironment(String environment) {
            this.environment = environment;
        }

        String getEnvironment() {
            return environment;
        }
    }

    public static void main(String[] args) {
        Configuration first = Configuration.getInstance();
        Configuration second = Configuration.getInstance();
        first.setEnvironment("production");

        System.out.println("Same instance: " + (first == second));
        System.out.println("Environment: " + second.getEnvironment());
    }
}

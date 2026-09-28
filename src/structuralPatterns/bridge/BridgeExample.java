public class BridgeExample {

    /** Abstracción común utilizada por el cliente. */
    interface Operation {
        String execute(String request);
    }

    /** Implementación concreta del comportamiento del ejemplo. */
    static class Service implements Operation {
        @Override
        public String execute(String request) {
            return "Bridge processed: " + request;
        }
    }

    /** Objeto que concentra la colaboración propia del patrón. */
    static class Context {
        private final Operation operation;

        Context(Operation operation) {
            this.operation = operation;
        }

        void run(String request) {
            String result = operation.execute(request);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Operation operation = new Service();
        Context context = new Context(operation);
        context.run("customer request");
    }
}

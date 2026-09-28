public class AdapterExample {

    interface PaymentProcessor {
        void pay(double amount);
    }

    static class LegacyPaymentGateway {
        void makePaymentInCents(int amountInCents) {
            System.out.println("Legacy gateway charged " + amountInCents + " cents");
        }
    }

    static class PaymentGatewayAdapter implements PaymentProcessor {
        private final LegacyPaymentGateway gateway;

        PaymentGatewayAdapter(LegacyPaymentGateway gateway) {
            this.gateway = gateway;
        }

        @Override
        public void pay(double amount) {
            int cents = (int) Math.round(amount * 100);
            gateway.makePaymentInCents(cents);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentGatewayAdapter(
                new LegacyPaymentGateway());
        processor.pay(49.99);
    }
}

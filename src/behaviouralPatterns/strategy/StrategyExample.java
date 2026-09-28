import java.util.Arrays;

public class StrategyExample {

    interface PricingStrategy {
        double calculate(double subtotal);
    }

    static class RegularCustomerPricing implements PricingStrategy {
        @Override
        public double calculate(double subtotal) {
            return subtotal;
        }
    }

    static class PremiumCustomerPricing implements PricingStrategy {
        @Override
        public double calculate(double subtotal) {
            return subtotal * 0.90;
        }
    }

    static class ShoppingCart {
        private final PricingStrategy pricingStrategy;

        ShoppingCart(PricingStrategy pricingStrategy) {
            this.pricingStrategy = pricingStrategy;
        }

        double total(double subtotal) {
            return pricingStrategy.calculate(subtotal);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new PremiumCustomerPricing());
        System.out.println("Final price: " + cart.total(100.0));
    }
}

import java.util.ArrayList;
import java.util.List;

public class ObserverExample {

    interface Subscriber {
        void onPriceChanged(String product, double price);
    }

    static class PriceMonitor {
        private final List<Subscriber> subscribers = new ArrayList<>();

        void subscribe(Subscriber subscriber) {
            subscribers.add(subscriber);
        }

        void changePrice(String product, double price) {
            System.out.println("Price changed: " + product + " -> $" + price);
            for (Subscriber subscriber : subscribers) {
                subscriber.onPriceChanged(product, price);
            }
        }
    }

    public static void main(String[] args) {
        PriceMonitor monitor = new PriceMonitor();
        monitor.subscribe((product, price) ->
                System.out.println("Email sent for " + product));
        monitor.subscribe((product, price) ->
                System.out.println("Dashboard updated for $" + price));
        monitor.changePrice("Mechanical keyboard", 89.90);
    }
}

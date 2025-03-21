package fit;

public class StockObserverDemo {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0);

        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        appleStock.registerObserver(investor1);
        appleStock.registerObserver(investor2);

        // Price changes
        appleStock.setPrice(155.0);
        appleStock.setPrice(160.0);

        // Remove one observer
        appleStock.removeObserver(investor1);
        appleStock.setPrice(165.0);
    }
}
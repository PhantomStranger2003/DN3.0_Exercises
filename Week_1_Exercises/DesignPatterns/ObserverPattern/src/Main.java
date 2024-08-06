// Main.java
package stockmarket;

public class Main {

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Simulate stock price updates
        stockMarket.setStockPrice(200.00);
        stockMarket.setStockPrice(300.0);

        stockMarket.deregisterObserver(mobileApp);

        // Simulate another stock price update
        stockMarket.setStockPrice(500.00);
    }
}

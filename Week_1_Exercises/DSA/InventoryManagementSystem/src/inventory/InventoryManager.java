// inventory/InventoryManager.java
package inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Product> productMap;

    public InventoryManager() {
        productMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(String productId) {
        productMap.remove(productId);
    }

    public Product getProduct(String productId) {
        return productMap.get(productId);
    }

    public void displayAllProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }
}

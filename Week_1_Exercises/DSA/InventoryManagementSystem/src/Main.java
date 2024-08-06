// Main.java
package inventory;

public class Main {

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Add products
        inventoryManager.addProduct(new Product("001", "Laptop", 10, 999.99));
        inventoryManager.addProduct(new Product("002", "Smartphone", 20, 499.99));

        // Display all products
        inventoryManager.displayAllProducts();

        // Update a product
        inventoryManager.updateProduct("001", 5, 899.99);

        // Display a specific product
        System.out.println(inventoryManager.getProduct("001"));

        // Delete a product
        inventoryManager.deleteProduct("002");

        // Display all products
        inventoryManager.displayAllProducts();
    }
}

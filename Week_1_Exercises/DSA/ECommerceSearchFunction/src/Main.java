// Main.java
package ecommerce;

public class Main {

    public static void main(String[] args) {
        Product[] products = {
                new Product("001", "Laptop", "Electronics"),
                new Product("002", "Smartphone", "Electronics"),
                new Product("003", "Desk", "Furniture"),
                new Product("004", "Chair", "Furniture"),
                new Product("005", "Headphones", "Electronics")
        };

        // Linear search
        Product foundProduct = SearchAlgorithms.linearSearch(products, "Desk");
        System.out.println("Linear Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));

        // Sort products by name for binary search
        SearchAlgorithms.sortProductsByName(products);

        // Binary search
        foundProduct = SearchAlgorithms.binarySearch(products, "Desk");
        System.out.println("Binary Search Result: " + (foundProduct != null ? foundProduct : "Product not found"));
    }
}

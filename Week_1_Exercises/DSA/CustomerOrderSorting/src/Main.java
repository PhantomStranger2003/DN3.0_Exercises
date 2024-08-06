// Main.java
package ecommerce;

public class Main {

    public static void main(String[] args) {
        Order[] orders = {
                new Order("001", "Alice", 250.50),
                new Order("002", "Bob", 150.75),
                new Order("003", "Charlie", 300.00),
                new Order("004", "Dave", 100.25),
                new Order("005", "Eve", 200.00)
        };

        // Sort using Bubble Sort
        SortingAlgorithms.bubbleSort(orders);
        System.out.println("Sorted using Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reinitialize orders array for Quick Sort
        orders = new Order[]{
                new Order("001", "Alice", 250.50),
                new Order("002", "Bob", 150.75),
                new Order("003", "Charlie", 300.00),
                new Order("004", "Dave", 100.25),
                new Order("005", "Eve", 200.00)
        };

        // Sort using Quick Sort
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        System.out.println("Sorted using Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

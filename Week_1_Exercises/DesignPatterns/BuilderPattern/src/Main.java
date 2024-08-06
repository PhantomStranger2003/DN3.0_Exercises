// Main.java
import computer.Computer;

public class Main {

    public static void main(String[] args) {
        // Create a Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA GeForce RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .build();

        System.out.println(gamingPC);

        // Create another Computer with a different configuration
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println(officePC);
    }
}

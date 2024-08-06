public class Main {

    public static void main(String[] args) {
        // Get instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify if both logger instances are the same
        System.out.println("Are logger1 and logger2 the same instance? " + (logger1 == logger2));

        // Test logging
        logger1.log("Testing Logger");
        logger2.log("Singleton Pattern Example");
    }
}

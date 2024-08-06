// Main.java
package notifications;

public class Main {

    public static void main(String[] args) {
        // Base notifier
        Notifier notifier = new EmailNotifier();

        // Adding SMS notification functionality
        notifier = new SMSNotifierDecorator(notifier);

        // Adding Slack notification functionality
        notifier = new SlackNotifierDecorator(notifier);

        // Send notification
        notifier.send("System update at 10 PM tonight.");
    }
}

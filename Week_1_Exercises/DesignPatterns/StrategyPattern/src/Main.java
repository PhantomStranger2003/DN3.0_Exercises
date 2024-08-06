// Main.java
package paymentsystem;

public class Main {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Using Credit Card payment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "John Doe", "123");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(2500.00);

        // Using PayPal payment strategy
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "securepassword");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(1500.00);
    }
}

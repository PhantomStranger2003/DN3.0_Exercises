// Main.java
package payment;

public class Main {

    public static void main(String[] args) {
        // Using Stripe payment gateway through adapter
        StripePaymentGateway stripeGateway = new StripePaymentGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(1000.0);

        // Using PayPal payment gateway through adapter
        PaypalPaymentGateway paypalGateway = new PaypalPaymentGateway();
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypalGateway);
        paypalProcessor.processPayment(2000.0);
    }
}

// payment/StripePaymentGateway.java
package payment;

public class StripePaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made through Stripe.");
    }
}

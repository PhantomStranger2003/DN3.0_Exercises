// payment/PaypalAdapter.java
package payment;

public class PaypalAdapter implements PaymentProcessor {

    private PaypalPaymentGateway paypalGateway;

    public PaypalAdapter(PaypalPaymentGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.sendPayment(amount);
    }
}

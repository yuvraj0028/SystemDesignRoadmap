abstract class PaymentProcessor {
    public abstract void processPayment(double amount);
}

class CreditCardPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPaymentProcessor extends PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

public class OpenClosed {
    public static void main(String[] args) {
        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        PaymentProcessor payPalProcessor = new PayPalPaymentProcessor();

        processPayment(creditCardProcessor, 100.0);
        processPayment(payPalProcessor, 50.0);      
    }

    public static void processPayment(PaymentProcessor paymentProcessor, double amount) {
        paymentProcessor.processPayment(amount);
    }
}

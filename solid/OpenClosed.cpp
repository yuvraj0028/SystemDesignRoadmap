#include <iostream>
#include <memory>
#include <vector>

// Abstract base for all payment processors
class PaymentProcessor {
public:
    virtual ~PaymentProcessor() = default;
    virtual void processPayment(double amount) = 0;
};

class CreditCardPaymentProcessor : public PaymentProcessor {
public:
    void processPayment(double amount) override {
        std::cout << "Processing credit card payment of $" << amount << std::endl;
    }
};

class PayPalPaymentProcessor : public PaymentProcessor {
public:
    void processPayment(double amount) override {
        std::cout << "Processing PayPal payment of $" << amount << std::endl;
    }
};

// Adding a new payment method only needs a new subclass, this function stays untouched
void processPayment(PaymentProcessor* paymentProcessor, double amount) {
    paymentProcessor->processPayment(amount);
}

int main() {
    auto creditCardProcessor = std::make_unique<CreditCardPaymentProcessor>();
    auto payPalProcessor = std::make_unique<PayPalPaymentProcessor>();

    processPayment(creditCardProcessor.get(), 100.0);
    processPayment(payPalProcessor.get(), 50.0);

    // the same code works for any processor added later
    std::vector<std::unique_ptr<PaymentProcessor>> processors;
    processors.push_back(std::make_unique<CreditCardPaymentProcessor>());
    processors.push_back(std::make_unique<PayPalPaymentProcessor>());

    for (const auto& processor : processors) {
        processPayment(processor.get(), 25.0);
    }

    return 0;
}
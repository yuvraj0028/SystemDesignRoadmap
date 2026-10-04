from abc import ABC, abstractmethod


# Abstract base for all payment processors
class PaymentProcessor(ABC):
    @abstractmethod
    def process_payment(self, amount: float) -> None:
        ...


class CreditCardPaymentProcessor(PaymentProcessor):
    def process_payment(self, amount: float) -> None:
        print(f"Processing credit card payment of ${amount}")


class PayPalPaymentProcessor(PaymentProcessor):
    def process_payment(self, amount: float) -> None:
        print(f"Processing PayPal payment of ${amount}")


# Adding a new payment method only needs a new subclass, this function stays untouched
def process_payment(payment_processor: PaymentProcessor, amount: float) -> None:
    payment_processor.process_payment(amount)


def main() -> None:
    credit_card_processor = CreditCardPaymentProcessor()
    pay_pal_processor = PayPalPaymentProcessor()

    process_payment(credit_card_processor, 100.0)
    process_payment(pay_pal_processor, 50.0)

    # the same code works for any processor added later
    for processor in [CreditCardPaymentProcessor(), PayPalPaymentProcessor()]:
        process_payment(processor, 25.0)


if __name__ == "__main__":
    main()
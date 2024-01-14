package edu.hz.payments;

// 6. Strategy Pattern
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with Credit Card: $" + amount);
    }
}

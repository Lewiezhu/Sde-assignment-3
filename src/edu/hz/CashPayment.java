package edu.hz;

import edu.hz.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with Cash: $" + amount);
    }
}

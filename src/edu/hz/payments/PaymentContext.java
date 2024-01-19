package edu.hz.payments;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext() {
    }

    public void setStrategy(PaymentStrategy paymentStrategy){
     this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        paymentStrategy.pay(amount);
    }
}

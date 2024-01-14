package edu.hz.products;

// Factory Method Pattern
public class Sword implements Product {
    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public double getPrice() {
        return 1000.0;
    }
}

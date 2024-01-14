package edu.hz.products;

// Factory Method Pattern
public class Laptop implements Product {
    @Override
    public String getName() {
        return "Laptop";
    }

    @Override
    public double getPrice() {
        return 1000.0;
    }
}

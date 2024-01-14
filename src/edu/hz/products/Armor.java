package edu.hz.products;

// Factory Method Pattern
public class Armor implements Product {
    @Override
    public String getName() {
        return "Armor";
    }

    @Override
    public double getPrice() {
        return 500.0;
    }
}

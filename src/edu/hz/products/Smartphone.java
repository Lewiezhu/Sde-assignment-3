package edu.hz.products;

import edu.hz.products.Product;

// Factory Method Pattern
public class Smartphone implements Product {
    @Override
    public String getName() {
        return "Smartphone";
    }

    @Override
    public double getPrice() {
        return 500.0;
    }
}

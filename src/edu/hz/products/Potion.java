package edu.hz.products;

public class Potion implements Product{
    @Override
    public String getName() {
        return "Potion";
    }

    @Override
    public double getPrice() {
        return 200;
    }
}
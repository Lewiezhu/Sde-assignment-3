package edu.hz;

// Factory Method Pattern
class Smartphone implements Product {
    @Override
    public String getName() {
        return "Smartphone";
    }

    @Override
    public double getPrice() {
        return 500.0;
    }
}

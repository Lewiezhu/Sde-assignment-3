package edu.hz;

// Factory Method Pattern
class Laptop implements Product {
    @Override
    public String getName() {
        return "Laptop";
    }

    @Override
    public double getPrice() {
        return 1000.0;
    }
}

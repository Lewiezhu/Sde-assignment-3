package edu.hz.products;

// Factory Method Pattern
public class LaptopFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Laptop();
    }
}

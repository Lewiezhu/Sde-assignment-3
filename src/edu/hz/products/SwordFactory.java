package edu.hz.products;

// Factory Method Pattern
public class SwordFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Sword();
    }
}

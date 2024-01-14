package edu.hz.products;

// Factory Method Pattern
public class ArmorFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Armor();
    }
}

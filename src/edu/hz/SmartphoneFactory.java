package edu.hz;

// Factory Method Pattern
public class SmartphoneFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Smartphone();
    }
}

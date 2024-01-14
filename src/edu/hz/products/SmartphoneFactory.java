package edu.hz.products;

import edu.hz.products.Product;
import edu.hz.products.ProductFactory;
import edu.hz.products.Smartphone;

// Factory Method Pattern
public class SmartphoneFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Smartphone();
    }
}

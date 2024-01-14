package edu.hz.products;

public class PotionFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new Potion();
    }
}

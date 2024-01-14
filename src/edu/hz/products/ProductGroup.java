package edu.hz.products;

import edu.hz.products.Product;

import java.util.ArrayList;
import java.util.List;

// 3. Composite Pattern
public class ProductGroup implements Product {
    private List<Product> products = new ArrayList<>();
    private String groupName;

    public ProductGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String getName() {
        return groupName;
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

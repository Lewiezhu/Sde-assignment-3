package edu.hz.commands;

import edu.hz.products.Product;

public class PurchaseCommand implements ShopCommand {
        private Product product;
        private Inventory inventory;

        public PurchaseCommand(Product product, Inventory inventory) {
            this.product = product;
            this.inventory = inventory;
        }

        @Override
        public void execute() {
            System.out.println("Purchasing " + product.getName() + " for $" + product.getPrice());
            inventory.addItem(product.getName());
        }
    }



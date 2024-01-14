package edu.hz.commands;

import edu.hz.products.Product;

public class PurchaseCommand {
        private Product product;

        public PurchaseCommand(Product product) {
            this.product = product;
        }

        @Override
        public void execute() {
            System.out.println("Purchasing " + product.getName() + " for $" + product.getPrice());
        }
    }
}

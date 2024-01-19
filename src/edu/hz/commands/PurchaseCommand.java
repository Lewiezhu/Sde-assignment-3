package edu.hz.commands;

import edu.hz.payments.PaymentStrategy;
import edu.hz.products.Product;

public class PurchaseCommand implements ShopCommand {
        private Product product;
        private Inventory inventory;
        private PaymentStrategy paymentStrategy;

    public PurchaseCommand(Product product, Inventory inventory, PaymentStrategy paymentStrategy) {
            this.product = product;
            this.inventory = inventory;
            this.paymentStrategy = paymentStrategy;
        }

        @Override
        public void execute() {
            System.out.println("Purchasing " + product.getName() + " for $" + product.getPrice());
            inventory.addItem(product.getName());
            paymentStrategy.pay(product.getPrice());
        }
    }



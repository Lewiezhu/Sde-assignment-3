package edu.hz.commands;

import edu.hz.payments.PaymentContext;
import edu.hz.payments.PaymentStrategy;
import edu.hz.products.Product;

public class PurchaseCommand implements ShopCommand {
        private Product product;
        private Inventory inventory;
        private PaymentContext paymentContext;

    public PurchaseCommand(Product product, Inventory inventory, PaymentContext paymentContext) {
            this.product = product;
            this.inventory = inventory;
            this.paymentContext = paymentContext;
        }

        @Override
        public void execute() {
            System.out.println("Purchasing " + product.getName() + " for $" + product.getPrice());
            inventory.addItem(product.getName());
            paymentContext.pay(product.getPrice());
        }
    }



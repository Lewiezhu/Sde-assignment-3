# sde_assignment-3
Introduction:
We each worked on a different pattern in our application. 
Lewie worked on implementing a Singleton,Proxy and Command pattern and 
James worked on implementing a Factory,Composite and Strategy pattern.

Creational design patterns
Singleton
Code:
``` 
public class RealShop implements Shop {
    private static RealShop instance;

    private RealShop() {
    }

    public static RealShop getInstance() {
        if (instance == null) {
            instance = new RealShop();
        }
        return instance;
    }
}
``` 
Explanation:
Everytime i call RealShop.getInstance(), it returns the single instance of RealShop,ensuring that im always working with the same shop instance and that there can be only one shop in the whole application.

Factory
Code:
Explanation

Structural design patterns
Proxy
Code:
``` 
public class ShopProxy implements Shop {
    private Shop realShop;
    private boolean isAuthenticated;

    public ShopProxy(Shop realShop) {
        this.realShop = realShop;
        this.isAuthenticated = false;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void authenticate(String password) {
        if ("darkness".equals(password.toLowerCase().trim())) {
            isAuthenticated = true;
            System.out.println("That is indeed correct!");
        } else {
            System.out.println("Sorry, adventurer! You did not pass my test, so you can't enter my shop");
            System.out.println("You get kicked out of the guild shop");
            System.exit(0);
        }
    }
}
```   
Explanation: The class ShopProxy I made acts as an proxy for realShop, An user has to be authenticated through the proxy otherwise to get access to the RealShop. In our case you have to answer a riddle through the proxy and if the answer is not equal to the answer in the proxy you will be denied.

Composite
Code:
Explanation:

Behavioural design patterns
Command
Code:
``` 
public interface ShopCommand {
    void execute();
}

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

public class InventoryCommand implements ShopCommand {
    private Inventory inventory;

    public InventoryCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        System.out.println("Adventurer's Inventory:");
        inventory.showItems();
    }}
 ```    
Explanation: The interface ShopCommand holds the method execute() that the PurchaseCommand and InventoryCommand must implement. InventoryCommand encapsulates the operation to display the adventurer's inventory. PurchaseCommand encapsulates the purchase operation. It stores the purchased product,inventory and paymentStrategy.

``` 
while (!exit && shopProxy.isAuthenticated()) {
            // Display available products
            System.out.println("\nAvailable Products:");
            System.out.println("1. Sword");
            System.out.println("2. Armor");
            System.out.println("3. Potion");
            System.out.println("4. Beginner's Package");
            System.out.println("\nOther options");
            System.out.println("5. Check inventory");
            System.out.println("6. Exit");

            // Get user choice
            System.out.print("\nEnter your choice (1-6): ");
            int userChoice = scanner.nextInt();
            Product toPurchase = null;

            // Execute commands based on user choice
            switch (userChoice) {
                case 1:
                    toPurchase = sword;
                    break;
                case 2:
                    toPurchase = armor;
                    break;
                case 3:
                    toPurchase = potion;
                    break;
                case 4:
                    toPurchase = beginnersPackage;
                    break;
                case 5:
                    new InventoryCommand(adventurerInventory).execute();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Exiting...");
            }

            if ( userChoice >=1 && userChoice<5 ) {
                // Choose a payment method
                System.out.println("\nChoose a payment method:");
                System.out.println("1. Credit Card");
                System.out.println("2. Cash");

                // Get user payment choice
                System.out.print("\nEnter your payment choice (1-2): ");
                int paymentChoice = scanner.nextInt();
                PaymentStrategy paymentStrategy = null;

                // Execute payment based on user choice
                switch (paymentChoice) {
                    case 1:
                        paymentStrategy = new CreditCardPayment();
                        break;
                    case 2:
                        paymentStrategy = new CashPayment();
                        break;
                    default:
                        System.out.println("Invalid payment choice. Exiting...");
                }
                if (paymentStrategy != null) {
                    new PurchaseCommand(toPurchase, adventurerInventory, paymentStrategy).execute();
                }
}
``` 
Explanation: When the user selects option 5, a new InventoryCommand is created with an instance of adventurerInventory and then execute the execute method. Wehn the user select option 1-4, a new Purchasecommand is created with the selected product,inventory and chosen payment strategy. The execute method of purchasecommand is being executed then.

Strategy
Code:
Explanation:

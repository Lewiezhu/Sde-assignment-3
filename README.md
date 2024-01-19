# sde_assignment-3
## Introduction:
We have made a little guild shop in the context of an RPG game using 6 different Design Patterns.
We each worked on a different pattern in our application. 
Lewie worked on implementing a Singleton, Proxy and Command pattern and 
James worked on implementing a Factory, Composite and Strategy pattern.

### Creational design patterns
#### Singleton
##### Code:
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
##### Explanation:
Every time I call RealShop.getInstance(), it returns the single instance of RealShop, ensuring that I'm always working with the same shop instance and that there can be only one shop in the whole application.

#### Factory
##### Code:
```
public interface ProductFactory {
    Product createProduct();
}

public class ArmorFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Armor();
    }
}
public class SwordFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Sword();
    }
}
public class PotionFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new Potion();
    }
}
``` 
##### Explanation:
We have different products in our application which implement the interface 'Product' and for each of these products, we have a factory to instantiate them. Above you can see the interface ProductFactory and the different factories: SwordFactory, ArmorFactory and PotionFactory which are the concrete factories that create a specific product. Products are not instantiated directly. Instead, a factory is used to instantiate them to decouple their creation from the rest of the code.

### Structural design patterns
#### Proxy
##### Code:
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
##### Explanation:
The class ShopProxy I made acts as a proxy for realShop, A user has to be authenticated through the proxy otherwise to get access to the RealShop. In our case, you have to answer a riddle through the proxy and if the answer is not equal to the answer in the proxy you will be denied.

#### Composite
##### Code:
```
public interface Product {
    String getName();
    double getPrice();
}

public class Armor implements Product {
    @Override
    public String getName() {
        return "Armor";
    }

    @Override
    public double getPrice() {
        return 500.0;
    }
}

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
```
##### Explanation:
We have the interface Product which is the initial component and the interface ProductGroup which is our composite. ProductGroup implements Product so it can be seen as a product as well, but it holds a list of Products such as Armors, Swords and Potions in our case without necessarily knowing what they are.

### Behavioural design patterns
#### Command
##### Code:
``` 
public interface ShopCommand {
    void execute();
}

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
##### Explanation:
The interface ShopCommand holds the method execute() that the PurchaseCommand and InventoryCommand must implement. InventoryCommand encapsulates the operation to display the adventurer's inventory. PurchaseCommand encapsulates the purchase operation. It stores the purchased product, inventory and paymentStrategy.

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
                PaymentContext paymentContext = new PaymentContext();

                // Execute payment based on user choice
                switch (paymentChoice) {
                    case 1:
                        paymentContext.setStrategy(new CreditCardPayment());
                        break;
                    case 2:
                        paymentContext.setStrategy(new CashPayment());
                        break;
                    default:
                        System.out.println("Invalid payment choice. Exiting...");
                }
                if (paymentChoice == 1||paymentChoice == 2) {
                    new PurchaseCommand(toPurchase, adventurerInventory, paymentContext).execute();
                }
            }
``` 
##### Explanation:
When the user selects option 5, a new InventoryCommand is created with an instance of adventurerInventory and then executes the execute() method. When the user selects option 1-4, a new PurchaseCommand is created with the selected product, inventory and chosen payment strategy. The execute() method of purchaseCommand is being executed then.

#### Strategy
##### Code:
```
public interface PaymentStrategy {
    void pay(double amount);
}

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext() {
    }

    public void setStrategy(PaymentStrategy paymentStrategy){
     this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount){
        paymentStrategy.pay(amount);
    }
}

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with Cash: $" + amount);
    }
}

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with Credit Card: $" + amount);
    }
}
``` 
##### Explanation:
For the payment of the objects, we use the Strategy Pattern to allow for different Payment methods such as Cash or CreditCard. We use the interface PaymentStrategy which has the method Pay, which the different methods implement and they only need the input of the amount that has to be paid and operate differently based on that. Currently, only the output changes from this but if for example, each payment method incurs its own additional cost, this can be relegated to these classes and also easily changed and chosen here. The PaymentContext here is used to save the PaymentStrategy being used and is used in the application as shown below.
```
                // Choose a payment method
                System.out.println("\nChoose a payment method:");
                System.out.println("1. Credit Card");
                System.out.println("2. Cash");

                // Get user payment choice
                System.out.print("\nEnter your payment choice (1-2): ");
                int paymentChoice = scanner.nextInt();
                PaymentContext paymentContext = new PaymentContext();

                // Execute payment based on user choice
                switch (paymentChoice) {
                    case 1:
                        paymentContext.setStrategy(new CreditCardPayment());
                        break;
                    case 2:
                        paymentContext.setStrategy(new CashPayment());
                        break;
                    default:
                        System.out.println("Invalid payment choice. Exiting...");
                }
                if (paymentChoice == 1||paymentChoice == 2) {
                    new PurchaseCommand(toPurchase, adventurerInventory, paymentContext).execute();
                }
```
Based on the user input, the right strategy is chosen and inside the PurchaseCommand, the paymentContext is passed on and used to perform the payment operation as shown below.
```
public void execute() {
        System.out.println("Purchasing " + product.getName() + " for $" + product.getPrice());
        inventory.addItem(product.getName());
        paymentContext.pay(product.getPrice());
    }
```

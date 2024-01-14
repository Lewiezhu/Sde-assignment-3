package edu.hz;

import edu.hz.commands.PurchaseCommand;
import edu.hz.commands.ShopCommand;
import edu.hz.products.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

// Creating the real shop as a Singleton
        Shop realShop = RealShop.getInstance();

        // Using the Factory Method Pattern
        ProductFactory swordFactory = new SwordFactory();
        ProductFactory smartphoneFactory = new ArmorFactory();
        ProductFactory potionFactory = new PotionFactory();

        Product sword = swordFactory.createProduct();
        Product armor = smartphoneFactory.createProduct();
        Product potion = potionFactory.createProduct();

        ProductGroup beginnersPackage= new ProductGroup("Beginner's Package");
        beginnersPackage.addProduct(sword);
        beginnersPackage.addProduct(armor);
        beginnersPackage.addProduct(potion);



        // Creating the shop proxy
        ShopProxy shopProxy = new ShopProxy(realShop);

        ShopCommand purchaseSwordCommand = new PurchaseCommand(sword);
        ShopCommand purchaseArmorCommand = new PurchaseCommand(armor);
        ShopCommand purchasePotionCommand = new PurchaseCommand(potion);



        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, adventurer! Would you like to enter or leave our shop");
        System.out.println("1. Enter the guild shop ");
        System.out.println("2. Leave ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nTo gain access to our shop you need to pass a test by answering this riddle.");
            System.out.println("The More That Is Here, The Less You Will See?");
            System.out.print("Enter your answer: ");
            String riddleAnswer = scanner.next();
            shopProxy.authenticate(riddleAnswer);
            shopProxy.enterShop();
        } else if (choice == 2) {
            System.out.println("Farewell, adventurer!");
        } else {
            System.out.println("Invalid choice. Please choose a valid option.");
        }
        // Display available products
        System.out.println("\nAvailable Products:");
        System.out.println("1. Sword");
        System.out.println("2. Armor");
        System.out.println("3. Potion");
        System.out.println("4. Beginnner's Package");

        // Get user choice
        System.out.print("\nEnter your choice (1-4): ");
        int userChoice = scanner.nextInt();

        // Execute commands based on user choice
        switch (userChoice) {
            case 1:
                purchaseSwordCommand.execute();
                break;
            case 2:
                purchaseArmorCommand.execute();
                break;
            case 3:
                purchasePotionCommand.execute();
                break;
            case 4:
                System.out.println("Price of Beginner's Package: $" + beginnersPackage.getPrice());
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }

    }
}

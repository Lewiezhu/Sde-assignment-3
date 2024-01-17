package edu.hz;

import edu.hz.commands.*;
import edu.hz.products.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Shop realShop = RealShop.getInstance();
        Inventory adventurerInventory = new AdventurerInventory();
        boolean exit = false;


        // Using the Factory Method Pattern
        ProductFactory swordFactory = new SwordFactory();
        ProductFactory smartphoneFactory = new ArmorFactory();
        ProductFactory potionFactory = new PotionFactory();

        Product sword = swordFactory.createProduct();
        Product armor = smartphoneFactory.createProduct();
        Product potion = potionFactory.createProduct();

        ProductGroup beginnersPackage = new ProductGroup("Beginner's Package");
        beginnersPackage.addProduct(sword);
        beginnersPackage.addProduct(armor);
        beginnersPackage.addProduct(potion);


        // Creating the shop proxy
        ShopProxy shopProxy = new ShopProxy(realShop);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, adventurer! Would you like to enter or leave our shop");
        System.out.println("1. Enter the guild shop ");
        System.out.println("2. Leave ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nTo gain access to our secret shop you need to pass a test by answering this riddle.");
            System.out.println("The More That Is Here, The Less You Will See?");
            System.out.println("Enter your answer: ");
            String riddleAnswer = scanner.next();
            shopProxy.authenticate(riddleAnswer);
            shopProxy.enterShop();
        } else if (choice == 2) {
            System.out.println("Farewell, adventurer!");
        } else {
            System.out.println("Invalid choice. Please choose a valid option.");
        }
        while (!exit) {
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

            // Execute commands based on user choice
            switch (userChoice) {
                case 1:
                    new PurchaseCommand(sword, adventurerInventory).execute();
                    break;
                case 2:
                    new PurchaseCommand(armor, adventurerInventory).execute();
                    break;
                case 3:
                    new PurchaseCommand(potion, adventurerInventory).execute();
                    break;
                case 4:
                    new PurchaseCommand(beginnersPackage, adventurerInventory).execute();
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
            if (!exit) {
                System.out.print("\nDo you want to buy something else? (y/n): ");
                String continueShoppingChoice = scanner.next().toLowerCase();
                if (!continueShoppingChoice.equals("y")) {
                    exit = true;
                    System.out.println("Farewell, adventurer!");
                }
            }
        }
    }
}
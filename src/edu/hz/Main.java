package edu.hz;

import edu.hz.commands.PurchaseCommand;
import edu.hz.commands.ShopCommand;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

// Creating the real shop as a Singleton
        Shop realShop = RealShop.getInstance();

        // Creating the shop proxy
        ShopProxy shopProxy = new ShopProxy(realShop);

        ShopCommand purchaseLaptopCommand = new PurchaseCommand(laptop);
        ShopCommand purchaseSmartphoneCommand = new PurchaseCommand(smartphone);


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
        System.out.println("1. Laptop");
        System.out.println("2. Smartphone");
        System.out.println("3. Electronics Group");

        // Get user choice
        System.out.print("\nEnter your choice (1-3): ");
        int userChoice = scanner.nextInt();

        // Execute commands based on user choice
        switch (userChoice) {
            case 1:
                purchaseLaptopCommand.execute();
                break;
            case 2:
                purchaseSmartphoneCommand.execute();
                break;
            case 3:
                System.out.println("Price of Electronics Group: $" + electronicsGroup.getPrice());
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }

    }
}

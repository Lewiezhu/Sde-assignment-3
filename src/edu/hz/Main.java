package edu.hz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

// Creating the real shop as a Singleton
        Shop realShop = RealShop.getInstance();

        // Creating the shop proxy
        ShopProxy shopProxy = new ShopProxy(realShop);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, adventurer! Would you like to enter or leave our shop");
        System.out.println("1. Enter the guild shop ");
        System.out.println("2. Leave ");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("To gain access to our shop you need to pass a test by answering this riddle.");
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
    }
}

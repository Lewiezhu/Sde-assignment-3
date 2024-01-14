package edu.hz;

public class SingletonTest {
    public static void main(String[] args) {
        // Attempt to create multiple instances
        RealShop shop1 = RealShop.getInstance();
        RealShop shop2 = RealShop.getInstance();

        // Check if both references point to the same instance
        if (shop1 == shop2) {
            System.out.println("Shop is a singleton because both references point to the same instance.");
        } else {
            System.out.println("Shop is not a singleton because multiple instances were created.");
        }
    }
}
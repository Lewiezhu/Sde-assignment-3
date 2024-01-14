package edu.hz;

class RealShop implements Shop {
    private static RealShop instance;

    private RealShop() {
        // Private constructor to prevent instantiation
    }

    public static RealShop getInstance() {
        if (instance == null) {
            instance = new RealShop();
        }
        return instance;
    }

    @Override
    public void enterShop() {
        System.out.println("You have entered the adventurer's guild shop.");
    }
}
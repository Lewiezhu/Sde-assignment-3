package edu.hz;

class Shop {
    private static Shop instance;

    private Shop() {
        // Private constructor to prevent instantiation
    }

    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }
}
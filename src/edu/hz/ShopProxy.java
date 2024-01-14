package edu.hz;

public class ShopProxy implements Shop {
    private Shop realShop;
    private boolean isAuthenticated;

    public ShopProxy(Shop realShop) {
        this.realShop = realShop;
        this.isAuthenticated = false;
    }

    public void authenticate(String password) {
        // Simplified authentication logic
        if ("darkness".equals(password)) {
            isAuthenticated = true;
            System.out.println("That is indeed correct!");
        } else {
            System.out.println("That is incorrect,please try again.");
        }
    }

    @Override
    public void enterShop() {
        if (isAuthenticated) {
            realShop.enterShop();
        } else {
            System.out.println("Sorry, adventurer! You are not allowed to access my shop without passing my test");
            System.out.println("You get kicked out of the guild shop");

        }
    }
}
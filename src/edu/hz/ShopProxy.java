package edu.hz;

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
            System.out.println("Sorry, adventurer! You did not pass my so you can't enter my shop");
            System.out.println("You get kicked out of the guild shop");
            System.exit(0);
        }
    }

    @Override
    public void enterShop() {
        if (isAuthenticated) {
            realShop.enterShop();
        } else {
            System.out.println("Sorry, adventurer! You are not allowed in my shop");
        }

    }
}
package edu.hz.commands;

public class ShowInventoryCommand implements ShopCommand {
    private Inventory inventory;

    public ShowInventoryCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        System.out.println("Adventurer's Inventory:");
        inventory.showItems();
    }
}
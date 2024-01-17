package edu.hz.commands;

public class InventoryCommand implements ShopCommand {
    private Inventory inventory;

    public InventoryCommand(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void execute() {
        System.out.println("Adventurer's Inventory:");
        inventory.showItems();
    }
}
package edu.hz.commands;

import java.util.ArrayList;
import java.util.List;

public class AdventurerInventory implements Inventory {
    private List<String> items;

    public AdventurerInventory() {
        this.items = new ArrayList<>();
    }

    @Override
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (String item : items) {
                System.out.println(item);
            }
        }
    }

    public void addItem(String item) {
        items.add(item);
    }

}
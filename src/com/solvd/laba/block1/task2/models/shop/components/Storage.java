package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.shop.components.interfaces.Sortable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Storageable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Storage implements Sortable, Storageable {
    private List<Item> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItems(List<Item> itemsToAdd) {
        items.addAll(itemsToAdd);
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public void decreaseQuantity(Item item, int quantity) {
        item.setQuantity(item.getQuantity() - quantity);
    }

    @Override
    public void increaseQuantity(Item item, int quantity) {
        item.setQuantity(item.getQuantity() + quantity);
    }

    @Override
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void sortByPrice() {
        List<Item> sortedByPrice = new ArrayList<>(items);
        sortedByPrice.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        System.out.println("Items in the Storage Sorted by Price");
        sortedByPrice.forEach(System.out::println);
    }

    @Override
    public void sortByQuantity() {
        List<Item> sortedByQuantity = new ArrayList<>(items);
        sortedByQuantity.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.getQuantity(), o2.getQuantity());
            }
        });
        System.out.println("Items in the Storage Sorted by Quantity");
        sortedByQuantity.forEach(System.out::println);
    }
}

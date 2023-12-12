package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.shop.components.exceptions.ItemNotFoundException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Searchable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Sortable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Storageable;
import com.solvd.laba.block1.task2.models.shop.components.shopping.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.solvd.laba.block1.task2.Main.logger;

public class Storage implements Sortable, Storageable, Searchable {
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
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElseThrow(ItemNotFoundException::new);
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
        logger.info("Items in the Storage Sorted by Price");
        sortedByPrice.forEach(logger::info);
    }

    @Override
    public void sortByQuantity() {
        List<Item> sortedByQuantity = new ArrayList<>(items);
        sortedByQuantity.sort(Comparator.comparingInt(Item::getQuantity));
        logger.info("Items in the Storage Sorted by Quantity");
        sortedByQuantity.forEach(logger::info);
    }

    public int getTotalAmount() {
        return items.stream()
                .mapToInt(Item::getQuantity)
                .sum();
    }
}

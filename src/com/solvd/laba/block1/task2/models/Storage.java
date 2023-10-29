package com.solvd.laba.block1.task2.models;

import java.util.ArrayList;
import java.util.List;

public class Storage {
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

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItems(List<Item> itemsToAdd) {
        items.addAll(itemsToAdd);
    }
}

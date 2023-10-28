package com.solvd.laba.block1.task2.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    private double totalPrice;

    public Cart() {
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

}

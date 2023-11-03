package com.solvd.laba.block1.task2.models;

import com.solvd.laba.block1.task2.models.persons.Customer;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final Customer customer;
    private List<Item> items;
    private double totalPrice;

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double calculateCart() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public void addItem(Item item) {
        items.add(item);
        setTotalPrice(calculateCart());
        System.out.printf("Item %s was added to the cart of user %s %s%n", item.getName(),
                customer.getName(),
                customer.getLastname());
    }

    public void removeItem(Item item) {
        items.remove(item);
        setTotalPrice(calculateCart());
        System.out.printf("Item %s was removed from your cart%n", item.getName());
    }

    public void decreaseQuantity(Item item, int quantity) {
        item.setQuantity(item.getQuantity() - quantity);
        setTotalPrice(calculateCart());
        System.out.printf("Quantity was decreased by %d, now you have %d %s in your cart%n", quantity,
                item.getQuantity(),
                item.getName());
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

}

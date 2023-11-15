package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.ItemNotFoundException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Searchable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Sortable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Storageable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static com.solvd.laba.block1.task2.Main.logger;

public final class Cart implements Sortable, Storageable, Searchable {

    private final Customer customer;
    private List<Item> items;
    private double totalPrice;

    public Cart(Customer customer) {
        this.customer = customer;
        this.items = new LinkedList<>();
    }

    public Customer getCustomer() {
        return customer;
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

    @Override
    public void addItem(Item item) {
        items.add(item);
        setTotalPrice(calculateCart());
        logger.info("Item {} was added to the cart of user {} {}", item.getName(),
                customer.getName(),
                customer.getLastname());
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
        setTotalPrice(calculateCart());
        logger.info("Item {} was removed from your cart", item.getName());
    }

    @Override
    public void decreaseQuantity(Item item, int quantity) {
        item.setQuantity(item.getQuantity() - quantity);
        setTotalPrice(calculateCart());
        logger.info("Quantity was decreased by {}, now you have {} {} in your cart", quantity,
                item.getQuantity(),
                item.getName());
    }

    @Override
    public void increaseQuantity(Item item, int quantity) {
        item.setQuantity(item.getQuantity() + quantity);
        setTotalPrice(calculateCart());
        logger.info("Quantity was increased by {}, now you have {} {} in your cart", quantity,
                item.getQuantity(),
                item.getName());
    }

    @Override
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new ItemNotFoundException();
    }

    @Override
    public void sortByPrice() {
        List<Item> sortedByPrice = new ArrayList<>(items);
        sortedByPrice.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.getQuantity(), o2.getQuantity());
            }
        });
        logger.info("Items in your cart sorted by price");
        sortedByPrice.forEach(logger::info);
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
        logger.info("Items in your cart sorted by quantity");
        sortedByQuantity.forEach(logger::info);
    }
}

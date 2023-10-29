package com.solvd.laba.block1.task2.models;

public class Item {

    private final long id;
    private final String name;
    private double price;
    private int amount; //Temp? Maybe better solution soon.

    //Constructor for item without price and amount yet
    public Item(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(long id, String name, double price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Name of product: " + name +
                "\nPrice: " + String.format("%.2f", price) +
                "\nAmount in stock: " + amount;
    }
}

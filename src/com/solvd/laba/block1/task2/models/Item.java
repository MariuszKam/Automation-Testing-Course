package com.solvd.laba.block1.task2.models;

public class Item {
    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private final long id;
    private final String name;
    private int price;
    private int amount; //Temp? Maybe better solution soon.

    //Constructor for item without price and amount yet
    public Item(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(long id, String name, int price, int amount) {
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

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }


}

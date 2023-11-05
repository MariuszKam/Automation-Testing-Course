package com.solvd.laba.block1.task2.models.shop.components;

public class Item {

    private final long id;
    private final String name;
    private double price;
    private int quantity;

    public Item(long id, String name, double price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = amount;
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

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int amount) {
        this.quantity = amount;
    }

    @Override
    public String toString() {
        return "Name of product: " + name +
                "\nPrice: " + String.format("%.2f", price) +
                "\nQuantity: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Double.compare(item.price, price) != 0) return false;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

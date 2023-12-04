package com.solvd.laba.block1.task2.models.shop.components.shopping;

import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidItemPriceException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.NegativeQuantityException;

public final class Item {

    private final long id;
    private final String name;
    private double price;
    private int quantity;
    private final Category category;

    public Item(long id, String name, double price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        if (price < 0) {
            throw new InvalidItemPriceException();
        }
        this.price = price;

        if (quantity < 0) {
            throw new NegativeQuantityException();
        }
        this.quantity = quantity;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new InvalidItemPriceException();
        }
        this.price = price;
    }

    public void setQuantity(int amount) {
        if (amount < 0) {
            throw new NegativeQuantityException();
        }
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

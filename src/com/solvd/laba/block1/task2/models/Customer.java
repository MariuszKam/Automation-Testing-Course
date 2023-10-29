package com.solvd.laba.block1.task2.models;

public class Customer extends Person {

    private final Cart cart;

    public Customer(long id, String name, String lastname) {
        super(id, name, lastname);
        cart = new Cart();
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    public Cart getCart() {
        return cart;
    }
}

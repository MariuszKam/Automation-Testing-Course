package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.Cart;

public class Customer extends Person {

    private final Cart cart;

    public Customer(long id, String name, String lastname) {
        super(id, name, lastname);
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }
}

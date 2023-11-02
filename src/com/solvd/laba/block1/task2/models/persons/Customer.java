package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.Cart;
import com.solvd.laba.block1.task2.models.Inquiry;

public class Customer extends Person {

    private final Cart cart;

    public Customer(long id, String name, String lastname) {
        super(id, name, lastname);
        cart = new Cart();
    }

    public Inquiry makeInquiry(String itemName) {
        return new Inquiry(name + " " + lastname, itemName);
    }

    public Cart getCart() {
        return cart;
    }
}

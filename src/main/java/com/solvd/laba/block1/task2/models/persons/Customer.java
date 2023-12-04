package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.shop.components.shopping.Cart;
import com.solvd.laba.block1.task2.models.shop.components.Inquiry;

public final class Customer extends Person {

    private final Cart cart;

    public Customer(long id, String name, String lastname) {
        super(id, name, lastname);
        cart = new Cart(this);

    }

    public Cart getCart() {
        return cart;
    }

    public Inquiry makeInquiry(String itemName) {
        return new Inquiry(this, itemName);
    }

    
}

package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.shop.components.Inquiry;

public final class Customer extends Person {

    public Customer(long id, String name, String lastname) {
        super(id, name, lastname);
    }

    public Inquiry makeInquiry(String itemName) {
        return new Inquiry(name + " " + lastname, itemName);
    }

}

package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.Inquiry;

public class Customer extends Person {

    private double balance;

    public Customer(long id, String name, String lastname, double balance) {
        super(id, name, lastname);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Inquiry makeInquiry(String itemName) {
        return new Inquiry(name + " " + lastname, itemName);
    }

}

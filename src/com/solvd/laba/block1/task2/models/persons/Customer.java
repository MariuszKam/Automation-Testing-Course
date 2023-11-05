package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.shop.components.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Balanceable;

public class Customer extends Person implements Balanceable {

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

    @Override
    public void showBalance() {
        System.out.printf("%s %s's account balance is %.2f$%n", name, lastname, balance);
    }

    @Override
    public boolean isPositive() {
        return balance >= 0;
    }

    @Override
    public void increaseBalance(double amount) {
        balance += amount;
    }

    @Override
    public void decreaseBalance(double amount) {
        double savePoint = balance;
        balance -= amount;
        if (!isPositive()) {
            balance = savePoint;
            System.out.println("Insufficient funds for operation");
        }
    }

    public Inquiry makeInquiry(String itemName) {
        return new Inquiry(name + " " + lastname, itemName);
    }

}

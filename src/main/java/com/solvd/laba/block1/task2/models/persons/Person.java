package com.solvd.laba.block1.task2.models.persons;

import com.solvd.laba.block1.task2.models.shop.components.exceptions.InsufficientFundsException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Balanceable;

import java.util.Objects;

public abstract class Person implements Balanceable {

    protected final long id;
    protected final String name;
    protected final String lastname;
    protected double balance;


    public Person(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.balance = 0.00;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
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
    public void increaseBalance(double amount) {
        balance += amount;
    }

    @Override
    public void decreaseBalance(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    @Override
    public String toString() {
        return "Person: " +
                "ID: " + id +
                "\nName: " + name +
                "\nLastname: " + lastname;
    }
}

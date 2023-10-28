package com.solvd.laba.block1.task2.models;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Employee> employees;
    private final Storage storage;
    private double balance;

    public Shop() {
        this.employees = new ArrayList<>();
        this.storage = new Storage();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Storage getStorage() {
        return storage;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

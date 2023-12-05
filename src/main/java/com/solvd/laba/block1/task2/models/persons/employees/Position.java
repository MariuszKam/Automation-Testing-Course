package com.solvd.laba.block1.task2.models.persons.employees;

public enum Position {
    MANAGER("Manager"),
    CUSTOMER_SERVICE("Customer Service"),
    ACCOUNTANT("Accountant");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}

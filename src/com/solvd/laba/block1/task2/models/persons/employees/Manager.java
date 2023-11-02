package com.solvd.laba.block1.task2.models.persons.employees;

public class Manager extends Employee {

    public Manager(long id, String name, String lastname, double salary) {
        super(id, name, lastname, salary);
        this.position = "Manager";
    }
}

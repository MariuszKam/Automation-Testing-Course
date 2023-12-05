package com.solvd.laba.block1.task2.models.persons.employees;

public class Accountant extends Employee {

    public Accountant(long id, String name, String lastname, double salary) {
        super(id, name, lastname, salary);
        this.position = Position.ACCOUNTANT;
    }

    @Override
    public void work() {
        System.out.println("Doing paper work");
    }




}

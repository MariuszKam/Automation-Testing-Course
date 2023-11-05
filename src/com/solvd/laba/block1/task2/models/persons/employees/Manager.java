package com.solvd.laba.block1.task2.models.persons.employees;

public final class Manager extends Employee {

    public Manager(long id, String name, String lastname, double salary) {
        super(id, name, lastname, salary);
        this.position = Position.MANAGER;
    }

    //OPP - part 2 - Create and override at least one abstract method.
    @Override
    public void work() {
        System.out.println("Oversees employees");
    }
}

package com.solvd.laba.block1.task2.models.persons.employees;

public class CustomerService extends Employee {

    public CustomerService(long id, String name, String lastname, double salary) {
        super(id, name, lastname, salary);
        this.position = "Customer Service";
    }


}

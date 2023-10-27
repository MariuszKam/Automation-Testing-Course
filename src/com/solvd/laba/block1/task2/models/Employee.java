package com.solvd.laba.block1.task2.models;

public class Employee extends Person {

    private int salary;

    public Employee(long id, String NAME, String LASTNAME, int salary) {
        super(id, NAME, LASTNAME);
        this.salary = salary;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getNAME() {
        return super.getNAME();
    }

    @Override
    public String getLASTNAME() {
        return super.getLASTNAME();
    }

    public int getSalary() {
        return salary;
    }
}

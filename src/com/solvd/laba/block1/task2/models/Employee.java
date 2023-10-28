package com.solvd.laba.block1.task2.models;

public class Employee extends Person {

    private double salary;
    private String position;

    public Employee(long id, String NAME, String LASTNAME, int salary, String position) {
        super(id, NAME, LASTNAME);
        this.salary = salary;
        this.position = position;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    @Override
    public String toString() {
        return "Employee:\n" +
                "Employee id: " + getId() +
                "\nName: " + getNAME() + " " + getLASTNAME() +
                "\nSalary: " + String.format("%.2f", salary) +
                "\nPosition: " + position;
    }
}

package com.solvd.laba.block1.task2.models;

public class Employee extends Person {

    private double salary;
    private String position;

    public Employee(long id, String name, String lastname, double salary, String position) {
        super(id, name, lastname);
        this.salary = salary;
        this.position = position;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
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
                "\nName: " + name + " " + lastname +
                "\nSalary: " + String.format("%.2f", salary) +
                "\nPosition: " + position;
    }
}

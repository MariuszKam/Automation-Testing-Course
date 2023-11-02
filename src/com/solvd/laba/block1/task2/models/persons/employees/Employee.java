package com.solvd.laba.block1.task2.models.persons.employees;

import com.solvd.laba.block1.task2.models.persons.Person;

import java.util.Objects;

public abstract class Employee extends Person {

    protected double salary;
    protected Position position;

    public Employee(long id, String name, String lastname, double salary) {
        super(id, name, lastname);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //OPP - part 2 - Create and override at least one abstract method.
    public abstract void work();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, position);
    }

    @Override
    public String toString() {
        return "Employee:\n" +
                "Employee id: " + getId() +
                "\nName: " + name + " " + lastname +
                "\nSalary: " + String.format("%.2f$", salary) +
                "\nPosition: " + position.getPosition();
    }


}

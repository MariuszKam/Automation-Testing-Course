package com.solvd.laba.block1.task2.models.persons.employees;

import java.util.List;

public class Accountant extends Employee {

    public Accountant(long id, String name, String lastname, double salary) {
        super(id, name, lastname, salary);
        this.position = Position.ACCOUNTANT;
    }

    public double calculatePayroll(List<Employee> employees) {
        return employees.stream().mapToDouble(employee -> employee.salary).sum();
    }

    @Override
    public void work() {
        System.out.println("Doing paper work");
    }


}

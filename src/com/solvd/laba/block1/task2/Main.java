package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.models.Employee;

public class Main {
    public static void main(String[] args) {
        //Start
        Employee employee = new Employee(1, "Name", "Lastname", 1000, "Manager");
        System.out.println(employee.getId() + " " + employee.getNAME() + " " + employee.getLASTNAME() + " " + employee.getSalary());
    }
}

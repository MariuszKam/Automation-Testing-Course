package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.models.Customer;
import com.solvd.laba.block1.task2.models.Employee;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.services.ShopService;

public class Main {
    public static void main(String[] args) {
        //Start
        Employee employee = new Employee(1, "Catarina", "O'Neil", 1000, "Manager");
        System.out.println(employee.getId() + " " + employee.getNAME() + " " + employee.getLASTNAME() + " " + employee.getSalary());
        //Simulation of putting item in a cart.
        Item pencil = new Item(1, "Pencil", 20.99, 10);
        Customer customer = new Customer(1, "Mark", "Schweinsteiger");
        System.out.println(customer.getCart().getItems()); //Empty
        customer.getCart().addItem(pencil);
        System.out.println(customer.getCart().getItems().get(0).getName());
        //ShopServices testing
        //Hire
        ShopService shopService = new ShopService();
        shopService.hire(employee);
        shopService.showStaff();
        //New Employee
        Employee employee2 = new Employee(2, "Derek", "Knight", 800, "Attendant");
        shopService.hire(employee2);
        shopService.showStaff();
        shopService.fire(employee);
        shopService.showStaff();


    }
}

package com.solvd.laba.block1.task2.services;

import com.solvd.laba.block1.task2.models.Employee;
import com.solvd.laba.block1.task2.models.Shop;


public class ShopService {
    private final Shop shop;

    public ShopService() {
        this.shop = new Shop();
    }

    public void hire(Employee employee) {
        shop.getEmployees().add(employee);
    }

    public void fire(Employee employee) {
        shop.getEmployees().remove(employee);
    }

    public void showStaff() {
        shop.getEmployees().forEach(System.out::println);
    }

    public void payroll() {
        double payroll = shop.getEmployees().stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Total amount that has to be paid this month to all the employees is " + payroll + "$");
        shop.setBalance(shop.getBalance() - payroll);
        System.out.println("New balance will be " + shop.getBalance() + "$");
    }


}

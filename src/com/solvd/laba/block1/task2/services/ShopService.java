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

    }

    
}

package com.solvd.laba.block1.task2.services;

import com.solvd.laba.block1.task2.models.Employee;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.models.Shop;

import java.util.List;


public class ShopService {
    private final Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;
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
        System.out.println("Total amount that has to be paid this month to all the employees is " + convertToMoney(payroll));
        shop.setBalance(shop.getBalance() - payroll);
        System.out.println("New balance will be " + convertToMoney(shop.getBalance()));
    }

    private String convertToMoney(double num) {
        return String.format("%.2f", num);
    }

    public void showInventory() {
        System.out.println("Products in stock: ");
        shop.getStorage().getItems().forEach(System.out::println);
    }

    public void addItem(Item item) {
        shop.getStorage().addItem(item);
    }

    public void addListOfItems(List<Item> items) {
        shop.getStorage().addItems(items);
    }


}

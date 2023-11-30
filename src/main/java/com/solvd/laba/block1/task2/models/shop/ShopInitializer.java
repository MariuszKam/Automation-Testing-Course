package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.persons.employees.Manager;

public class ShopInitializer {
    private static final Shop shop;
    private static final String URL = "src/main/resources/task2/";

    static {
        shop = new Shop();
        initializeEmployees();
        initializeItems();
    }

    public static Shop getShop() {
        return shop;
    }

    private static void initializeEmployees() {
        //Creating Staff
        //OOP - part 2 - Use polymorphism with at least one abstract class.
        Employee employee1 = new Manager(1, "Mark", "Williams", 2200.00);
        Employee employee2 = new CustomerService(2, "Sophie", "Turner", 1500.00);
        //Add staff to shop
        shop.getEmployees().add(employee1);
        shop.getEmployees().add(employee2);
    }

    private static void initializeItems() {
        //Creating products
        shop.getStorage().setItems(DataLoader.itemLoader(URL + "items.csv"));
    }
}

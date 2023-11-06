package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.persons.employees.Manager;
import com.solvd.laba.block1.task2.models.shop.components.Item;

public class ShopInitializer {
    private static final Shop shop;

    static {
        shop = new Shop();
        initializeEmployees(shop);
        initializeItems(shop);
    }

    public static Shop getShop() {
        return shop;
    }

    public static void initializeEmployees(Shop shop) {
        //Creating Staff
        //OOP - part 2 - Use polymorphism with at least one abstract class.
        Employee employee1 = new Manager(1, "Mark", "Williams", 2200.00);
        Employee employee2 = new CustomerService(2, "Sophie", "Turner", 1500.00);
        //Add staff to shop
        shop.getEmployees().add(employee1);
        shop.getEmployees().add(employee2);
    }

    public static void initializeItems(Shop shop) {
        //Creating products
        Item item1 = new Item(1, "Pencil", 0.99, 500);
        Item item2 = new Item(2, "Book", 14.99, 10);
        Item item3 = new Item(3, "Ball", 50.99, 80);
        Item item4 = new Item(4, "Sunglasses", 4.99, 250);

        //Add products to shop
        shop.getStorage().addItem(item1);
        shop.getStorage().addItem(item2);
        shop.getStorage().addItem(item3);
        shop.getStorage().addItem(item4);
    }
}

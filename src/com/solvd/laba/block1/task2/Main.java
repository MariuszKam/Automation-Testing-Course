package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.Customer;
import com.solvd.laba.block1.task2.models.Employee;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.models.Shop;

public class Main {
    public static void main(String[] args) {
        //Creating Shop
        Shop shop = new Shop();

        //Creating Staff
        Employee employee1 = new Employee(1, "Mark", "Williams", 1200.00, "Manager");
        Employee employee2 = new Employee(2, "Sophie", "Turner", 1500.00, "Customer Service");

        //Add staff to shop
        shop.getEmployees().add(employee1);
        shop.getEmployees().add(employee2);

        //Creating products
        Item item1 = new Item(1, "Pencil", 2.50, 50);
        Item item2 = new Item(2, "Book", 10.00, 10);

        //Add products to shop
        shop.getStorage().addItem(item1);
        shop.getStorage().addItem(item2);

        //Creating customer
        Customer customer = new Customer(1, "Adam", "Smith");

        //Put item to cart
        customer.getCart().addItem(item1);
        customer.getCart().addItem(item2);
    }
}

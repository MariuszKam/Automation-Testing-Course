package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.persons.employees.Manager;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.components.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.Item;

public class Main {
    public static void main(String[] args) {
        //Creating Shop
        Shop shop = new Shop();

        //Creating Staff
        //OOP - part 2 - Use polymorphism with at least one abstract class.
        Employee employee1 = new Manager(1, "Mark", "Williams", 2200.00);
        Employee employee2 = new CustomerService(2, "Sophie", "Turner", 1500.00);

        //Test Employees
        System.out.println(employee1);
        System.out.println(employee2);

        //Add staff to shop
        shop.getEmployees().add(employee1);
        shop.getEmployees().add(employee2);

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

        //Creating customers
        Customer customer1 = new Customer(1, "Adam", "Smith");
        Customer customer2 = new Customer(2, "Lucas", "Miller");

        //Inquiry
        Inquiry inquiry = customer1.makeInquiry("Pencil");
        System.out.println(inquiry);
        shop.handleInquiry(inquiry);
        System.out.println(inquiry);

        //Customer - Scenario one: Successful transaction.
        shop.assignCart(customer1); //Implement method where shop assigns cart to a customer
        //Storage before transaction
        shop.printStorage();
        //Adding and removing a PART of order
        shop.addItem("Pencil", 3);
        shop.removeItem("Pencil", 2);
        shop.printCart();
        //Finally removing entire order
        shop.removeItem("Pencil", 1);
        shop.printCart();
        //Filling up cart again
        shop.addItem("Pencil", 9);
        shop.addItem("Book", 5);
        shop.addItem("Sunglasses", 10);
        shop.addItem("Ball", 1);
        shop.printCart();
        //Printing total price
        shop.showTotalPrice();
        //Applying promo code
        shop.applyPromoCode("NONEXISTENT");
        shop.applyPromoCode("10NOW");
        //Finishing transaction
        shop.checkout();
        //Changes in storage after successful transaction
        shop.printStorage();
        //Balance changes
        System.out.println(customer1.getBalance());
        System.out.println(shop.getBalance());

        //Customer - Scenario two: Failed transaction.
        shop.assignCart(customer2);
        //Filling up cart
        shop.addItem("Pencil", 3);
        shop.addItem("Book", 2);
        //Try to finish transaction
        shop.checkout();
        //Possible to reject by public method
        //shop.rejectOrder();
        //Storage didn't change
        shop.printStorage();

    }
}

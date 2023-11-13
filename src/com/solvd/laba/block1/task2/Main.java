package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.ShopInitializer;
import com.solvd.laba.block1.task2.models.shop.components.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Sortable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Creating Shop
        Shop shop = ShopInitializer.getShop();

        //Creating customers
        Customer customer1 = new Customer(1, "Adam", "Smith");
        Customer customer2 = new Customer(2, "Lucas", "Miller");

        //Inquiry
        Inquiry inquiry = customer1.makeInquiry("Pencil");
        logger.info(inquiry);
        shop.handleInquiry(inquiry);
        logger.info(inquiry);


        //Customer - Scenario one: Successful transaction.
        System.out.println("\nFirst case\n");
        shop.assignCart(customer1); //Implement method where shop assigns cart to a customer
        //Storage before transaction
        shop.printStorage();
        //Adding and removing a PART of order
        shop.addItemToCustomerCart(customer1, "Pencil", 3);
        shop.showTotalPrice(customer1);
        shop.printStorage();
        shop.removeItemFromCustomerCart(customer1, "Pencil", 2);
        shop.printStorage();
        shop.printCart(customer1);
        //Finally removing entire order
        shop.removeItemFromCustomerCart(customer1, "Pencil", 1);
        shop.printCart(customer1);
        //Filling up cart again
        shop.addItemToCustomerCart(customer1, "Pencil", 9);
        shop.addItemToCustomerCart(customer1, "Book", 7);
        shop.addItemToCustomerCart(customer1, "Sunglasses", 13);
        shop.addItemToCustomerCart(customer1, "Ball", 1);
        //Polymorphism Interfaces
        System.out.println("Polymorphism Interfaces: ");
        List<Sortable> sortableList = new ArrayList<>();
        sortableList.add(shop.getStorage());
        sortableList.add(shop.getCustomerCart().get(customer1));
        sortableList.forEach(Sortable::sortByPrice);
        //Printing total price
        shop.showTotalPrice(customer1);
        //Applying promo code
        try {
            shop.applyPromoCode(customer1, "NONEXISTENT");
        } catch (InvalidPromoCodeException e) {
            logger.warn(e.getMessage());
        }
        try {
            shop.applyPromoCode(customer1, "10NOW");
        } catch (InvalidPromoCodeException e) {
            logger.warn(e.getMessage());
        }
        //Lend some money to customer
        customer1.increaseBalance(500);
        //Finishing transaction
        shop.checkout(customer1);
        //Changes in storage after successful transaction
        shop.printStorage();
        //Balance changes
        System.out.printf("Change in customer balance: %.2f$%n", customer1.getBalance());
        System.out.printf("Change in shop balance: %.2f$%n", shop.getBalance());

        //Customer - Scenario two: Failed transaction.
        System.out.println("\nSecond case\n");
        shop.assignCart(customer2);
        //Filling up cart
        shop.addItemToCustomerCart(customer2, "Pencil", 3);
        shop.addItemToCustomerCart(customer2, "Book", 2);
        //Try to finish transaction
        //shop.checkout(customer2);
        //Possible to reject by public method
        //shop.rejectOrder();
        //Storage didn't change
        shop.printStorage();

    }
}

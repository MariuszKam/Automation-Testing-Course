package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.Initializer;
import com.solvd.laba.block1.task2.models.shop.components.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.CartEmptyException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Sortable;
import com.solvd.laba.block1.task2.models.shop.components.shopping.CartActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Creating Shop
        Shop shop = Initializer.getShop();

        Customer customer1 = shop.getCustomers().get(0);
        Customer customer2 = shop.getCustomers().get(1);

        //Inquiry
        Inquiry inquiry = customer1.makeInquiry("Pencil");
        logger.info(inquiry);
        shop.addInquiry(inquiry);
        shop.processInquiries();
        logger.info(inquiry);


        //Customer - Scenario one: Successful transaction.
        System.out.println("\nFirst case\n");
        //Storage before transaction
//        shop.printStorage();
        //Adding and removing a PART of order
        //shop.customerAction(Customer, Action, Item, Quantity);
        shop.performCartAction(customer1, CartActions.ADD_ITEM, "Pencil", 3);
        System.out.println(customer1.getCart().getItems());
        shop.performCartAction(customer1, CartActions.REMOVE_ITEM, "Pencil", 3);
        System.out.println(customer1.getCart().getItems());
//        shop.addItemToCustomerCart(customer1, "Pencil", 3);
//        shop.showTotalPrice(customer1);
//        shop.printStorage();
//        shop.removeItemFromCustomerCart(customer1, "Pencil", 2);
//        shop.printStorage();
//        shop.printCart(customer1);
//        //Finally removing entire order
//        shop.removeItemFromCustomerCart(customer1, "Pencil", 1);
//        shop.printCart(customer1);
//        //Filling up cart again
//        shop.addItemToCustomerCart(customer1, "Pencil", 9);
//        shop.addItemToCustomerCart(customer1, "Book", 7);
//        shop.addItemToCustomerCart(customer1, "Sunglasses", 13);
//        shop.addItemToCustomerCart(customer1, "Ball", 1);
//        //Polymorphism Interfaces
//        System.out.println("Polymorphism Interfaces: ");
//        List<Sortable> sortableList = new ArrayList<>();
//        sortableList.add(shop.getStorage());
//        sortableList.add(shop.getCustomerCart().get(customer1));
//        sortableList.forEach(Sortable::sortByPrice);
//        //Printing total price
//        shop.showTotalPrice(customer1);
//        //Applying promo code
//        shop.applyPromoCode(customer1, "NONEXISTENT");
//        shop.applyPromoCode(customer1, "PROMO5");
//        //Lend some money to customer
//        customer1.increaseBalance(500);
//        //Finishing transaction
//        try {
//            shop.checkout(customer1);
//        } catch (CartEmptyException e) {
//            logger.warn(e.getMessage());
//        }
//        //Changes in storage after successful transaction
//        shop.printStorage();
//        //Balance changes
//        System.out.printf("Change in customer balance: %.2f$%n", customer1.getBalance());
//        System.out.printf("Change in shop balance: %.2f$%n", shop.getBalance());
//
//        //Customer - Scenario two: Failed transaction.
//        System.out.println("\nSecond case\n");
//        //Filling up cart
//        shop.addItemToCustomerCart(customer2, "Pencil", 3);
//        shop.addItemToCustomerCart(customer2, "Book", 2);
//        //Try to finish transaction
//        try {
//            shop.checkout(customer2);
//        } catch (CartEmptyException e) {
//            logger.warn(e.getMessage());
//        }
//        //Possible to reject by public method
//        //shop.rejectOrder();
//        //Storage didn't change
//        shop.printStorage();

    }
}

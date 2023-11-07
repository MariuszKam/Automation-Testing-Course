package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.ShopInitializer;
import com.solvd.laba.block1.task2.models.shop.components.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.Storage;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Sortable;

public class Main {
    public static void main(String[] args) {
        //Creating Shop
        Shop shop = ShopInitializer.getShop();

        //Polymorphism interface
        Sortable sortable = new Storage();

        //Creating customers
        Customer customer1 = new Customer(1, "Adam", "Smith");
        Customer customer2 = new Customer(2, "Lucas", "Miller");

        //Inquiry
        Inquiry inquiry = customer1.makeInquiry("Pencil");
        System.out.println(inquiry);
        shop.handleInquiry(inquiry);
        System.out.println(inquiry);

        //Customer - Scenario one: Successful transaction.
        System.out.println("\nFirst case\n");
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
        shop.addItem("Sunglasses", 13);
        shop.addItem("Ball", 1);
        shop.printCart();
        //Printing total price
        shop.showTotalPrice();
        //Applying promo code
        shop.applyPromoCode("NONEXISTENT");
        shop.applyPromoCode("10NOW");
        //Lend some money to customer
        customer1.increaseBalance(500);
        //Finishing transaction
        shop.checkout();
        //Changes in storage after successful transaction
        shop.printStorage();
        //Balance changes
        System.out.println(customer1.getBalance());
        System.out.println(shop.getBalance());

        //Customer - Scenario two: Failed transaction.
        System.out.println("\nSecond case\n");
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

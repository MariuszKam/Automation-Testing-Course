package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.ShopInitializer;
import com.solvd.laba.block1.task2.models.shop.components.Inquiry;

public class Main {
    public static void main(String[] args) {
        //Creating Shop
        Shop shop = ShopInitializer.getShop();

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

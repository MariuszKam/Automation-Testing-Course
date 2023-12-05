package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.Initializer;
import com.solvd.laba.block1.task2.models.shop.components.inquiry.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.CartEmptyException;
import com.solvd.laba.block1.task2.models.shop.components.payment.PaymentMethod;
import com.solvd.laba.block1.task2.models.shop.components.shopping.CartActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        shop.printStorage();
        //Adding and removing a PART of order
        CartActions.ADD_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Pencil"), 3);
        CartActions.PRINT_CART.accept(customer1.getCart());
        System.out.println(shop.getStorage().getItemByName("Pencil"));
        CartActions.REMOVE_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Pencil"), 2);
        CartActions.PRINT_CART.accept(customer1.getCart());
        System.out.println(shop.getStorage().getItemByName("Pencil"));
        //Finally removing entire order
        CartActions.REMOVE_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Pencil"), 1);
        CartActions.PRINT_CART.accept(customer1.getCart());
        System.out.println(shop.getStorage().getItemByName("Pencil"));
        //Filling up cart again
        CartActions.ADD_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Pencil"), 9);
        CartActions.ADD_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Book"), 7 );
        CartActions.ADD_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Sunglasses"), 13);
        CartActions.ADD_ITEM.perform(customer1.getCart(), shop.getStorage().getItemByName("Ball"), 1);

        //Printing total price
        CartActions.SHOW_PRICE.accept(customer1.getCart());
        //Applying promo code
        CartActions.APPLY_CODE.accept(customer1.getCart(), "NONEXISTENT");
        CartActions.APPLY_CODE.accept(customer1.getCart(), "PROMO5");
        //Lend some money to customer
        customer1.increaseBalance(500);
        //Finishing transaction
        try {
            shop.checkout(customer1, PaymentMethod.CASH);
        } catch (CartEmptyException e) {
            logger.warn(e.getMessage());
        }
        //Changes in storage after successful transaction
        shop.printStorage();
        //Balance changes
        System.out.printf("Change in customer balance: %.2f$%n", customer1.getBalance());
        System.out.printf("Change in shop balance: %.2f$%n", shop.getBalance());


        //Customer - Scenario two: Failed transaction.
        System.out.println("\nSecond case\n");
        //Filling up cart
        CartActions.ADD_ITEM.perform(customer2.getCart(), shop.getStorage().getItemByName("Pencil") ,3);
        CartActions.ADD_ITEM.perform(customer2.getCart(), shop.getStorage().getItemByName("Book"), 2);
        //Try to finish transaction
        try {
            shop.checkout(customer2, PaymentMethod.PAYPAL);
        } catch (CartEmptyException e) {
            logger.warn(e.getMessage());
        }
        //Possible to reject by public method
        CartActions.ORDER_REJECT.accept(customer2.getCart(), shop);
        //Storage didn't change
        shop.printStorage();


    }
}

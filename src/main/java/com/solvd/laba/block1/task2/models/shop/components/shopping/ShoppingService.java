package com.solvd.laba.block1.task2.models.shop.components.shopping;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.components.discount.DiscountService;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;

import static com.solvd.laba.block1.task2.Main.logger;

public final class ShoppingService {
    private static Shop shop;

    public static void setShop(Shop shop) {
        ShoppingService.shop = shop;
    }

    public static void performCartAction(Customer customer, CartAction cartAction, String itemName, int quantity) {
        cartAction.perform(customer.getCart(), shop.getStorage().getItemByName(itemName), quantity);
    }

    public static void printCart(Customer customer) {
        if (customer.getCart().getItems().isEmpty()) {
            logger.warn("Your cart is empty");
        }
        customer.getCart().getItems().forEach(logger::info);
    }

    private static void showTotalPrice(Customer customer) {
        String price = String.format("%.2f", customer.getCart().getTotalPrice());
        logger.info("Total price of your cart is: {}", price);
    }

    public static void applyPromoCode(Customer customer, String code) {
        //TODO: Make Try-catch and exception here for cart <if customer doesn't have one>
        try {
            customer.getCart().setTotalPrice(DiscountService.countPrice(code, customer.getCart()));
            logger.info("Code applied!");
            showTotalPrice(customer);
        } catch (InvalidPromoCodeException e) {
            logger.warn(e.getMessage());
        }
    }

//    public void checkout(Customer customer) throws CartEmptyException {
//        if (customerCart.get(customer).getItems().isEmpty()) {
//            throw new CartEmptyException();
//        }
//        if (payment.makePayment(this, customer)) {
//            //Successful apply to storage and clear the cart
//            confirmOrder(customer);
//        }
//    }

    private void confirmOrder(Customer customer) {
        customer.getCart().getItems().clear();
        logger.info("Thank you for choosing our shop!");
    }

    public void rejectOrder(Customer customer) {
        for (Item item : customer.getCart().getItems()) {
            Item inStorage = shop.getStorage().getItemByName(item.getName());
            inStorage.setQuantity(inStorage.getQuantity() + item.getQuantity());
        }
        customer.getCart().getItems().clear();
        logger.warn("Order rejected!");
    }
}

package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.shop.Shop;

public class Payment {

    private boolean isSuccessful;

    public Payment() {
        this.isSuccessful = false;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public boolean makePayment(Shop shop, Cart cart) {
        double customerBalance = cart.getCustomer().getBalance();
        double toPay = cart.getTotalPrice();
        //Check if sufficient funds in balance
        if (customerBalance >= toPay) {
            //Set new balance of customer and shop
            cart.getCustomer().decreaseBalance(toPay);
            shop.increaseBalance(toPay);
            return true;
        }
        return false;
    }
}

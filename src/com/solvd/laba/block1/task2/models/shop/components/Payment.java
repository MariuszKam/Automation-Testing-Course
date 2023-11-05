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

    public boolean makePayment(Shop shop) {
        double customerBalance = shop.getCart().getCustomer().getBalance();
        double toPay = shop.getCart().getTotalPrice();
        //Check if sufficient funds in balance
        if (customerBalance >= toPay) {
            //Set new balance of customer and shop
            shop.getCart().getCustomer().setBalance(customerBalance - toPay);
            shop.setBalance(shop.getBalance() + toPay);
            return true;
        }
        return false;
    }
}

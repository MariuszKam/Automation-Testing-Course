package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InsufficientFundsException;

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

//    public boolean makePayment(Shop shop, Customer customer) {
//        double customerBalance = customer.getBalance();
//        double toPay = shop.getCustomerCart().get(customer).getTotalPrice();
//        //Check if sufficient funds in balance
//        if (customerBalance >= toPay) {
//            //Set new balance of customer and shop
//            customer.decreaseBalance(toPay);
//            shop.increaseBalance(toPay);
//            return true;
//        }
//        shop.rejectOrder(customer);
//        throw new InsufficientFundsException();
//    }
}

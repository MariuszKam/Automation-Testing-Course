package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InsufficientFundsException;
import com.solvd.laba.block1.task2.models.shop.components.shopping.CartActions;

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

    public boolean makePayment(Customer customer, Shop shop) {
        double customerBalance = customer.getBalance();
        double toPay = customer.getCart().getTotalPrice();
        //Check if sufficient funds in balance
        if (customerBalance >= toPay) {
            //Set new balance of customer and shop
            customer.decreaseBalance(toPay);
            shop.increaseBalance(toPay);
            return true;
        }
        CartActions.ORDER_REJECT.accept(customer.getCart(), shop);
        throw new InsufficientFundsException();
    }
}

package com.solvd.laba.block1.task2.models.shop.components.payment;

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

    public void makePayment(Customer customer, Shop shop, PaymentMethod paymentMethod) {
        double customerBalance = customer.getBalance();
        double toPay = customer.getCart().getTotalPrice();
        //Check if sufficient funds in balance
        if (customerBalance >= toPay) {
            //Set new balance of customer and shop
            paymentMethod.paymentMadeBy(toPay);
            customer.decreaseBalance(toPay);
            shop.increaseBalance(toPay);
        } else {
            CartActions.ORDER_REJECT.accept(customer.getCart(), shop);
            throw new InsufficientFundsException();
        }
    }
}

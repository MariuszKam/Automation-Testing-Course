package com.solvd.laba.block1.task2.models.shop.components.payment;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.Shop;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InsufficientFundsException;
import com.solvd.laba.block1.task2.models.shop.components.shopping.CartActions;

import static com.solvd.laba.block1.task2.Main.logger;

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
        try {
            customer.decreaseBalance(toPay);
            shop.increaseBalance(toPay);
            paymentMethod.paymentMadeBy(toPay);
        } catch (InsufficientFundsException e) {
            CartActions.ORDER_REJECT.accept(customer.getCart(), shop);
            logger.warn(e.getMessage());
        }
    }
}

package com.solvd.laba.block1.task2.models.shop.components.payment;

import static com.solvd.laba.block1.task2.Main.logger;
public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    PAYPAL("PayPal"),
    CASH("Cash");

    private final String methodName;

    PaymentMethod(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void paymentMadeBy(double amount) {
       logger.info ("Transaction for {} provided by {}", amount, methodName);
    }
}

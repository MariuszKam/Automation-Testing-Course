package com.solvd.laba.block1.task2.models.shop.components.payment;

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
        System.out.printf("Transaction for %.2f provided by %s%n", amount, methodName);
    }
}

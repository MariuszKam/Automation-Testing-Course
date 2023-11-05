package com.solvd.laba.block1.task2.models.shop.components.interfaces;

public interface Balanceable {
    void showBalance();

    boolean isPositive();

    void increaseBalance(double amount);

    void decreaseBalance(double amount);

}

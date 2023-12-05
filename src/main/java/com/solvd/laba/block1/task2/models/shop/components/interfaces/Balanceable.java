package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.shop.components.exceptions.InsufficientFundsException;

public interface Balanceable {
    void showBalance();

    void increaseBalance(double amount);

    void decreaseBalance(double amount) throws InsufficientFundsException;

}

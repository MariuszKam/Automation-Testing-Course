package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class AccountantNotFoundException extends Exception{
    public AccountantNotFoundException() {
        super("No Accountant in company!");
    }
}

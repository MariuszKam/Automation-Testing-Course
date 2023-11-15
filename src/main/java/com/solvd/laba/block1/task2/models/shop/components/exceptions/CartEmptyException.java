package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class CartEmptyException extends Exception {
    public CartEmptyException() {
        super("Cart is empty!");
    }
}

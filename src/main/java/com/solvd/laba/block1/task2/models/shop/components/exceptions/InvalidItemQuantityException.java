package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class InvalidItemQuantityException extends RuntimeException {
    public InvalidItemQuantityException() {
        super("Quantity is less than zero");
    }
}

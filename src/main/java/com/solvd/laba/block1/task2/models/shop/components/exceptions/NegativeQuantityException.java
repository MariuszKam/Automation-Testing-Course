package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class NegativeQuantityException extends RuntimeException {
    public NegativeQuantityException() {
        super("Quantity is less than zero");
    }
}

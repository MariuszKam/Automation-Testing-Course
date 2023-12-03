package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class NegativePriceException extends RuntimeException {
    public NegativePriceException() {
        super("Price can't be negative");
    }
}

package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class InvalidItemPriceException extends RuntimeException {
    public InvalidItemPriceException() {
        super("Price is less than zero");
    }
}

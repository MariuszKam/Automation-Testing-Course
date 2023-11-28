package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class InvalidQuantityException extends RuntimeException{
    public InvalidQuantityException (String action) {
        super("Not enough quantity to " + action);
    }
}

package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class InvalidPromoCodeException extends Exception {
    public InvalidPromoCodeException() {
        super("Invalid promo code! Please try again!");
    }
}

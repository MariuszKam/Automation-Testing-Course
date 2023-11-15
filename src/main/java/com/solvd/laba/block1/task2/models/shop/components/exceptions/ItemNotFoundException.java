package com.solvd.laba.block1.task2.models.shop.components.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item not found!");
    }
}

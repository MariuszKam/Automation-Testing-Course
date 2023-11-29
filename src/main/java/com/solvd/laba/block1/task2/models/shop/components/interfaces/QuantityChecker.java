package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.shop.components.Item;

@FunctionalInterface
public interface QuantityChecker<T extends Item> {
    boolean checkQuantity(T item, int requiredQuantity);

}

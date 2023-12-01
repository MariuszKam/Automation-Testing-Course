package com.solvd.laba.block1.task2.models.shop.components.discount;

import com.solvd.laba.block1.task2.models.shop.components.Item;

@FunctionalInterface
public interface DiscountCalculator<T extends Item> {
    double calculateDiscount(T item, double discount);
}

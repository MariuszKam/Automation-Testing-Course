package com.solvd.laba.block1.task2.models.shop.components.discount;

import com.solvd.laba.block1.task2.models.shop.components.Cart;

@FunctionalInterface
public interface DiscountCalculator<T extends Cart> {
    double calculateDiscount(T Cart, double discount);
}

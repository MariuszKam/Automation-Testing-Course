package com.solvd.laba.block1.task2.models.shop.components.discount;

import com.solvd.laba.block1.task2.models.shop.components.Item;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.DiscountCalculator;

public class DiscountCalculators {

    // Lambda expression for calculating discount based on a percentage
    public static final DiscountCalculator<Item> PERCENTAGE_DISCOUNT = (item, discount) ->
            item.getPrice() * (1 - discount / 100);

    // Lambda expression for calculating discount based on a fixed amount
    public static final DiscountCalculator<Item> FIXED_AMOUNT_DISCOUNT = (item, discount) ->
            item.getPrice() - discount;

    // Method reference for calculating a flat 10% discount
    public static final DiscountCalculator<Item> FLAT_TEN_PERCENT_DISCOUNT = (item, discount) ->
            PERCENTAGE_DISCOUNT.calculateDiscount(item, 10);
}

package com.solvd.laba.block1.task2.models.shop.components.discount;

import com.solvd.laba.block1.task2.models.shop.components.Cart;

public class DiscountCalculators {

    // Lambda expression for calculating discount based on a percentage
    public static final DiscountCalculator<Cart> PERCENTAGE_DISCOUNT = (cart, discount) ->
            cart.getTotalPrice() * (1 - discount / 100);

    // Lambda expression for calculating discount based on a fixed amount
    public static final DiscountCalculator<Cart> FIXED_AMOUNT_DISCOUNT = (cart, discount) ->
            cart.getTotalPrice() - discount;

    // Method reference for calculating a flat 10% discount
    public static final DiscountCalculator<Cart> FLAT_TEN_PERCENT_DISCOUNT = (cart, discount) ->
            PERCENTAGE_DISCOUNT.calculateDiscount(cart, 10);
}

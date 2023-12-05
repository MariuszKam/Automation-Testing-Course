package com.solvd.laba.block1.task2.models.shop.components.discount;

import com.solvd.laba.block1.task2.models.shop.components.shopping.Cart;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.NegativePriceException;

public class DiscountCalculators {

    // Lambda expression for calculating discount based on a percentage
    public static final DiscountCalculator<Cart> PERCENTAGE_DISCOUNT = (cart, discount) ->
            cart.getTotalPrice() * (1 - discount / 100);

    // Lambda expression for calculating discount based on a fixed amount
    public static final DiscountCalculator<Cart> FlAT_DISCOUNT = (cart, discount) ->
    {
        if (cart.getTotalPrice() < discount) {
            throw new NegativePriceException();
        }
        return cart.getTotalPrice() - discount;
    };

}

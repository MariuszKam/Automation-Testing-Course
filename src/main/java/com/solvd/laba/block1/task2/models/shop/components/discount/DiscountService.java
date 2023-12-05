package com.solvd.laba.block1.task2.models.shop.components.discount;


import com.solvd.laba.block1.task2.models.shop.Initializer;
import com.solvd.laba.block1.task2.models.shop.components.shopping.Cart;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;

import java.util.Map;



public class DiscountService {
    private static final Map<String, PromoCode> promoCodes = Initializer.initializePromoCodes();

    public Map<String, PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }


    public static double countPrice(String code, Cart cart) throws InvalidPromoCodeException {
        //Need to make discount to items in cart!
        //Check if promo Code exists
        if (promoCodes.containsKey(code)) {
            //Proceed promotion!
            PromoCode promoCode = promoCodes.get(code);
            DiscountCalculator<Cart> discountCalculator;
            //Check if it's flat or not and set implementation
            if (promoCode.getDiscountType().isFlat()) {
                discountCalculator = DiscountCalculators.FlAT_DISCOUNT;
            } else {
                discountCalculator = DiscountCalculators.PERCENTAGE_DISCOUNT;
            }
            return finalPrice(cart, promoCode.getValue(), discountCalculator);
        }
        throw new InvalidPromoCodeException();
    }

    private static double finalPrice(Cart cart, double discount, DiscountCalculator<Cart> discountCalculator) {
        return Math.round(discountCalculator.calculateDiscount(cart, discount) * 100.00) / 100.00;
    }
}

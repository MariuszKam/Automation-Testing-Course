package com.solvd.laba.block1.task2.models.shop.components.discount;



import com.solvd.laba.block1.task2.models.shop.components.Cart;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;

import java.util.HashMap;
import java.util.Map;


public class DiscountService {
    private final Map<String, PromoCode> promoCodes;

    public DiscountService() {
        this.promoCodes = new HashMap<>();
    }

    public Map<String, PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.put(promoCode.getCode(), promoCode);
    }

    public void processCode(String code, Cart cart) throws InvalidPromoCodeException {
        //Need to make discount to items in cart!
        //Check if promo Code exists
        if (promoCodes.containsKey(code)) {
            //Proceed promotion!


        }
        throw  new InvalidPromoCodeException();
    }

    private
}

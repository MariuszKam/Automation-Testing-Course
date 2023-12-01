package com.solvd.laba.block1.task2.models.shop.components.discount;

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
}

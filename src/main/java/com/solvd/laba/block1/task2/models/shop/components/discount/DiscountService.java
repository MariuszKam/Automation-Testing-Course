package com.solvd.laba.block1.task2.models.shop.components.discount;

import java.util.HashSet;
import java.util.Set;

public class DiscountService {
    private final Set<PromoCode> promoCodes;

    public DiscountService() {
        this.promoCodes = new HashSet<>();
    }

    public Set<PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void addPromoCode(PromoCode promoCode) {
        promoCodes.add(promoCode);
    }
}

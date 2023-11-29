package com.solvd.laba.block1.task2.models.shop.components.discount;

import java.util.Objects;

public class PromoCode {
    private final String code;
    private boolean available;

    public PromoCode(String code) {
        this.code = code;
        this.available = true;
    }

    public String getCode() {
        return code;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromoCode promoCode = (PromoCode) o;
        return available == promoCode.available && Objects.equals(code, promoCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, available);
    }
}

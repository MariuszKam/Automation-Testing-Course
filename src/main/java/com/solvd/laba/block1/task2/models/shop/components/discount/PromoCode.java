package com.solvd.laba.block1.task2.models.shop.components.discount;

import java.util.Objects;

public class PromoCode {
    private final long id;
    private final String code;

    private final double value;
    private final boolean flat;
    private boolean available;

    public PromoCode(long id, String code, double value, boolean flat) {
        this.id = id;
        this.code = code;
        this.value = value;
        this.flat = flat;
        this.available = true;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getValue() {
        return value;
    }

    public boolean isFlat() {
        return flat;
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

package com.solvd.laba.block1.task2.models.shop.components.discount;

public enum DiscountType {
    PERCENTAGE("Percentage Discount", false),
    FLAT("Fixed Amount Discount", true);

    private final String typeName;
    private final boolean flat;

    DiscountType(String typeName, boolean flat) {
        this.typeName = typeName;
        this.flat = flat;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isFlat() {
        return flat;
    }
}

package com.solvd.laba.block1.task2.models.shop.components.discount;

import static com.solvd.laba.block1.task2.Main.logger;

public enum DiscountType {
    PERCENTAGE("Percentage Discount", false),
    FLAT("Flat Amount Discount", true);

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

    public void discountInfo() {
        logger.info("This discount is {}", getTypeName());
    }
}

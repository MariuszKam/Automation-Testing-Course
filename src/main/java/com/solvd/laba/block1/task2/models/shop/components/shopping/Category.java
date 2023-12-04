package com.solvd.laba.block1.task2.models.shop.components.shopping;

import java.util.function.Predicate;

public enum Category {
    ACCESSORIES("Accessories", false),
    ELECTRONICS("Electronics", true),
    FURNITURE("Furniture", true);

    private final String displayName;
    private final boolean hasWarranty;

    Category(String displayName, boolean hasWarranty) {
        this.displayName = displayName;
        this.hasWarranty = hasWarranty;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean hasWarranty() {
        return hasWarranty;
    }
}

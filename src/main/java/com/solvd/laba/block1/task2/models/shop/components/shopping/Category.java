package com.solvd.laba.block1.task2.models.shop.components.shopping;

import java.util.function.Predicate;

import static com.solvd.laba.block1.task2.Main.logger;

public enum Category {
    ACCESSORIES("Accessories", false, 0),
    ELECTRONICS("Electronics", true, 12),
    FURNITURE("Furniture", true, 24);

    private final String displayName;
    private final boolean hasWarranty;
    private final int warrantyTime;

    Category(String displayName, boolean hasWarranty, int warrantyTime) {
        this.displayName = displayName;
        this.hasWarranty = hasWarranty;
        this.warrantyTime = warrantyTime;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean hasWarranty() {
        return hasWarranty;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void warrantyInfo() {
        if (hasWarranty) {
            logger.info("This item has {} months of warranty", getWarrantyTime());
        } else {
            logger.info("Does not have warranty");
        }
    }
}

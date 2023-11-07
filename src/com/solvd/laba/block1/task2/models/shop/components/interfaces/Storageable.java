package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.shop.components.Item;

public interface Storageable {
    void addItem(Item item);

    void removeItem(Item item);

    void decreaseQuantity(Item item, int quantity);

    void increaseQuantity(Item item, int quantity);
}

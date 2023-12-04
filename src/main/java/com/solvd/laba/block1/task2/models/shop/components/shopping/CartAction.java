package com.solvd.laba.block1.task2.models.shop.components.shopping;

import com.solvd.laba.block1.task2.models.shop.components.Item;


@FunctionalInterface
public interface CartAction {
    void perform(Cart cart, Item item, int quantity);
}

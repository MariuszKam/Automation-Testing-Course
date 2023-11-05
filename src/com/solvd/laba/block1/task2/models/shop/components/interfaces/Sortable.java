package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.shop.components.Item;

import java.util.List;

public interface Sortable {
    void sortByPrice(List<Item> items);

    void sortByAmount(List<Item> items);
}

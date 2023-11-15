package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.shop.components.Item;

public interface Searchable {
    Item getItemByName(String name);
}

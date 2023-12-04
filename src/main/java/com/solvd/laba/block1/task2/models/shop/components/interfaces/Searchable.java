package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.shop.components.shopping.Item;

public interface Searchable {
    Item getItemByName(String name);
}

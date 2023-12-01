package com.solvd.laba.block1.task2.models.shop.components.dataloader;

@FunctionalInterface
public interface DataParser<T> {
    T parse(String[] data);
}

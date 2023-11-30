package com.solvd.laba.block1.task2.models.shop;

@FunctionalInterface
public interface DataParser<T> {
    T parser(String[] data);
}

package com.solvd.laba.block1.task1b;

import java.util.Arrays;

public class InsertionSort implements Sortable {

    private final String NAME = "Insertion";

    @Override
    public int[] sort(int[] array) {
        int j, key;
        for (int i = 1; i < array.length; i++) {
            j = i;
            key = array[i];
            while (j > 0 && array[j - 1] > key) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
        }
        return array;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

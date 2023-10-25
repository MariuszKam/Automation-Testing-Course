package com.solvd.laba.block1.task1b;

import java.util.Arrays;

public class InsertionSort implements Sortable {

    private final String NAME = "Insertion";

    @Override
    public int[] sort(int[] array) {
        int[] copyOfArray = Arrays.copyOf(array, array.length);
        int j, key;
        for (int i = 1; i < copyOfArray.length; i++) {
            j = i;
            key = copyOfArray[i];
            while (j > 0 && copyOfArray[j - 1] > key) {
                copyOfArray[j] = copyOfArray[j - 1];
                j--;
            }
            copyOfArray[j] = key;
        }
        return copyOfArray;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

package com.solvd.laba.block1.task1b;

import java.util.Arrays;

public class SelectionSort implements Sortable {

    private final String NAME = "Selection";
    @Override
    public int[] sort(int[] array) {
        int[] copyOfArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < copyOfArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < copyOfArray.length; j++) {
                if (copyOfArray[j] < copyOfArray[min]) {
                    min = j;
                }
            }
            int change = copyOfArray[min];
            copyOfArray[min] = copyOfArray[i];
            copyOfArray[i] = change;
        }
        return copyOfArray;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

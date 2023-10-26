package com.solvd.laba.block1.task1b;

public class SelectionSort implements Sortable {

    private final String NAME = "Selection";

    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int change = array[min];
            array[min] = array[i];
            array[i] = change;
        }
        return array;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

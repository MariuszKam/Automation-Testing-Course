package com.solvd.laba.block1.task1b;

public class BubbleSort implements Sortable {

    private final String NAME = "Bubble";

    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        };
        return array;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

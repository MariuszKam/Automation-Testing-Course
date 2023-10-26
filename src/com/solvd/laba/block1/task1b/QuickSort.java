package com.solvd.laba.block1.task1b;

public class QuickSort implements Sortable {

    private final String NAME = "Quicksort";
    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int partition = partition(array, start, end);
            quickSort(array, start, partition - 1);
            quickSort(array, partition + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        int swap;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }
        swap = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swap;

        return i + 1;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

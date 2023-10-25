package com.solvd.laba.block1.task1b;

public class Main {
    public static void main(String[] args) {
        int[] array = ArrayCreator.createRandomArray(10);
        ArrayCreator.printArray(array);
        InsertionSort insertionSort = new InsertionSort();
        ArrayCreator.printArray(insertionSort.sort(array));
        ArrayCreator.printArray(array);

    }
}

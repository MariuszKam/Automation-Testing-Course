package com.solvd.laba.block1.task1b;

public class MergeSort implements Sortable {

    private final String NAME = "Merge";

    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middleOfArray = array.length / 2;
        int[] leftSide = new int[middleOfArray];
        int[] rightSide = new int[array.length - middleOfArray];
        for (int i = 0; i < leftSide.length; i++) {
            leftSide[i] = array[i];
        }
        for (int i = middleOfArray; i < array.length; i++) {
            rightSide[i - middleOfArray] = array[i];
        }
        //Recursion
        leftSide = sort(leftSide);
        rightSide = sort(rightSide);

        return marge(leftSide, rightSide);
    }

    private int[] marge(int[] leftSide, int[] rightSide) {
        int[] result = new int[leftSide.length + rightSide.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < leftSide.length || rightPointer < rightSide.length) {
            if (leftPointer < leftSide.length && rightPointer < rightSide.length) {
                if (leftSide[leftPointer] < rightSide[rightPointer]) {
                    result[resultPointer++] = leftSide[leftPointer++];
                } else {
                    result[resultPointer++] = rightSide[rightPointer++];
                }
            } else if (leftPointer < leftSide.length) {
                result[resultPointer++] = leftSide[leftPointer++];
            } else {
                result[resultPointer++] = rightSide[rightPointer++];
            }
        }
        return result;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

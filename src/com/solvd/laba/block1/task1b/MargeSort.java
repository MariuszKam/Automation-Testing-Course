package com.solvd.laba.block1.task1b;

public class MargeSort implements Sortable {

    private final String NAME = "Marge";
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

        //Need method to marge
        return 
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

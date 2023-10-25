package com.solvd.laba.block1.task1b;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creating array with random numbers
        int[] array = ArrayCreator.createRandomArray(1000);
        //Variables used to count time
        long startTime, endTime;
        //List of algorithms
        List<Sortable> sortables = List.of(
                new InsertionSort(),
                new SelectionSort()
        );
        for (Sortable sortable:sortables) {
            startTime = System.currentTimeMillis();
            ArrayCreator.printArray(sortable.sort(array));
            endTime = System.currentTimeMillis();
            System.out.println("Time taken by " + sortable.getName() + " algorithm to sort the array: " + (endTime - startTime) + " milliseconds");
        }
        //ArrayCreator.printArray(array);

    }
}

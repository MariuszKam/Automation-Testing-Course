package com.solvd.laba.block1.task1b;

import java.util.Arrays;
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
                new SelectionSort(),
                new BubbleSort()
        );
        int[] copyOfArray;

        System.out.println("Array: ");
        ArrayCreator.printArray(array);
        for (Sortable sortable:sortables) {
            copyOfArray = Arrays.copyOf(array, array.length);
            startTime = System.currentTimeMillis();
            System.out.println(sortable.getName() + " algorithm: ");
            ArrayCreator.printArray(sortable.sort(copyOfArray));
            endTime = System.currentTimeMillis();
            System.out.println("Time taken by " + sortable.getName() + " algorithm to sort the array: " + (endTime - startTime) + " milliseconds" + "\n");
        }
        //ArrayCreator.printArray(array);

    }
}

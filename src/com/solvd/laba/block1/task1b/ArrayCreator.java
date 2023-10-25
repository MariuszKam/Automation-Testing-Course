package com.solvd.laba.block1.task1b;

import java.util.Random;


public class ArrayCreator {

    public static int[] createRandomArray(int amount) {
        Random random = new Random();
        int[] array = new int[amount];
        //Feeding array with random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int num:array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

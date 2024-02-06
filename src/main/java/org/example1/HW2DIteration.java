package org.example1;

import java.util.Arrays;

public class HW2DIteration {

    public static void main(String[] args) {
        int[][] numbers = {
                {5, 10, 15},
                {20, 25, 30}
        };


        printTwoDimensionalArray(numbers);
        printNumbersInNewLine(numbers);
        printAllOneDimensionalArrays(numbers);
        printOnlyFirstArray(numbers);
        printArrayOutOfBoundException(numbers);
        printAllNumbersInIndex(numbers,0);
    }

    private static void printTwoDimensionalArray(int[][] numbers) {
        for (int[] elem: numbers) {
            System.out.println(Arrays.toString(elem));
        }
    }

    private static void printNumbersInNewLine(int[][] numbers) {
        for (int[] elem: numbers) {
            for (int item: elem) {
                System.out.println(item);
            }
        }
    }

    private static void printAllOneDimensionalArrays(int[][] numbers) {
        for (int index = 0; index< numbers.length; index++) {
            System.out.println(Arrays.toString(numbers[index]));
        }
    }

    private static void printOnlyFirstArray(int[][] numbers) {
        for (int index=0; index<1; index++) {
            System.out.println(Arrays.toString(numbers[index]));
        }
    }

    private static void printArrayOutOfBoundException(int[][] numbers) {
        for (int index=0; index<5; index++) {
            System.out.println(Arrays.toString(numbers[index]));
        }
    }

    private static void printAllNumbersInIndex(int[][] numbers, int index) {
        if(index == numbers.length) {
            return;
        }
        printOneDArrayRecursion(numbers[index], 0);
        index = index + 1;
        printAllNumbersInIndex(numbers, index);
        System.out.println("done for index: "+index);
    }

    private static void printOneDArrayRecursion(int[] numbers, int index) {
        if(index == numbers.length) {
            return;
        }
        System.out.println(numbers[index]);
        index = index + 1;
        printOneDArrayRecursion(numbers, index);
    }
}

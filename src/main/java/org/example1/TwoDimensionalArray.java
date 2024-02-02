package org.example1;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[] ages = {23, 24};
        System.out.println(ages); // for any reference type it calls toString() method implementation given in Object class
        System.out.println(Arrays.toString(ages));
        // ages is an 1d array
        // elem type is int
        int[][] stats = {};
        // stats is an 2d array
        // elem type is 1d array of int i.e int[]
        int[][] marks = {
                {1,2},
                {2,3},
                {20, 30, 40}
        };
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(Arrays.toString(marks[2]));
        System.out.println(marks[2][0]);
        System.out.println(marks[2][1]);
        System.out.println(marks[2][2]);

        String[][] items = new String[3][2];
        // 3 1d arrays at index 0, 1, 2
        // size of each 1d array is 2 i.e 0 index and 1 index
        System.out.println(items[0].length);
        System.out.println(items[1].length);
        System.out.println(items[2].length);
        System.out.println(Arrays.toString(items[2]));

        System.out.println("----------------------------------");
        int[][] items1 = new int[3][2];
        // 3 1d array and each of them has 2 elements.
        // as we have not initialized the 1d array so each of them it will default element values of int type.
        System.out.println(Arrays.toString(items1[0]));
        System.out.println(Arrays.toString(items1[1]));
        System.out.println(Arrays.toString(items1[2]));
        items1[0] = new int[]{23, 24, 26}; // re-initialized
        items1[1] = new int[1]; // [0]
        items1[2] = new int[]{}; // []

        System.out.println(Arrays.toString(items1[0]));
        System.out.println(Arrays.toString(items1[1]));
        System.out.println(Arrays.toString(items1[2]));

        int[] item2 = new int[]{};
        System.out.println(Arrays.toString(item2)); // []
        System.out.println(item2.length); // 0

        int[] item3 = new int[1];
        System.out.println(Arrays.toString(item3)); // [0] default value of int
        System.out.println(item3.length); // 1

        int[][] items4 = new int[3][]; // all the 1d array here will be null because size of second array is not defined
        items4[1] = new int[]{2,3,4};// random length 1d array
        items4[2] = new int[]{2,3};// random length 1d array
        System.out.println(items4[0]); // default value will be null because 1d array is reference type
        System.out.println(Arrays.toString(items4[1]));
        System.out.println(Arrays.toString(items4[2]));

    }
}

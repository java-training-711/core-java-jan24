package org.example1;

import java.util.Arrays;

public class TwoDimensionalArrayIteration {

    public static void main(String[] args) {
        int[][] arr = {
                {20, 30, 40},
                {50, 60, 70},
                {80, 90, 100},
        };

        for (int[] elem : arr) {
            System.out.println(Arrays.toString(elem));
        }

        // format: ctrl alt L
        for (int[] elem : arr) {
            for (int item : elem) {
                System.out.println(item);
            }
            System.out.println("\n");
        }

        // do index based 2d array iteration
    }


}

package org.example1;

import java.util.Arrays;

public class ArrayWithMethods {

    public static void main(String[] args) {
        arrayAsMethodParam();
        arrayAsReturnType();
    }

    private static void arrayAsReturnType() {
        int[] arr = {2, 3, 4}; // 4,  9, 16
        int[] result = findSquares(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result));
    }

    private static int[] findSquares(int[] numbers) {
        int[] squareResults = new int[numbers.length];

        int index = 0;
        for (int elem : numbers) {
            squareResults[index] = (int) Math.pow(elem, 2);
            index++;
        }
        return squareResults;
    }


    private static void arrayAsMethodParam() {
        int[] arr1 = {10, 20, 30};
        System.out.println(arr1.hashCode());
        m1(arr1);
        System.out.println(Arrays.toString(arr1));
    }


    // how to pass array as parameter and modify
    public static void m1(int[] items){
//        System.out.println(Arrays.hashCode(items));
        System.out.println(items.hashCode());
        items[0] = 100;
        System.out.println(Arrays.toString(items)); // 100, 20, 30
    }
}

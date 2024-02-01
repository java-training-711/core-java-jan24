package org.example1;

public class ArrayIndexOutOfBound {
    public static void main(String[] args) {

        int[] ages = {23, 25}; // size is fixed for array
        System.out.println(ages[0]);
        System.out.println(ages[1]);
//        System.out.println(ages[2]);  //  java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2

        ages[2] = 100; // "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2

    }
}

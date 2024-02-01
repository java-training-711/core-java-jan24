package org.example1;

import java.util.Arrays;

public class ArrayObjectClass {
    public static void main(String[] args) {
        int[] ages = {23, 25};
        System.out.println(ages.getClass());

        String[] names = {"JOHN", "ALEX"};
        System.out.println(names.getClass());

        Integer[] marks = {};
        System.out.println(marks.getClass());

        System.out.println(ages.hashCode());
        System.out.println(Arrays.hashCode(ages));

    }
}

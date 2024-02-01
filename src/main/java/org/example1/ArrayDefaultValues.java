package org.example1;

public class ArrayDefaultValues {
    public static void main(String[] args) {
// names is array of String elements, so each element will be String.
// default value of String will be assigned.
// String is not a primitive type. It is a reference type. for any reference type default value will be null
        String[] names = new String[2];
        names[0] = "JOHN";
        System.out.println(names[0]);
        System.out.println(names[1]);

        int[] age = new int[2];
        System.out.println(age[0]);
        System.out.println(age[1]);

        Integer[] marks = new Integer[2];
        System.out.println(marks[0]);
        System.out.println(marks[1]);
    }
}

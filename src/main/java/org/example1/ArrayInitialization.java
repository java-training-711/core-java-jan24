package org.example1;

public class ArrayInitialization {

    public static void main(String[] args) {
        String name = "JOHN";
        // name is a variable. name is a variable of reference type String.
        String[] names = {};
        // names is a variable of reference type String[]
        System.out.println(names.length);
        String[] cities = {"DELHI", "MUMBAI"};
        System.out.println(cities.length);
        String[] fruits = new String[]{"APPLE", "BANANA"};
        System.out.println(fruits.length);
        String[] books = new String[2]; // 2 elements
        // 0 : MATH | 1: PHY
        books[0] = "MATH";
        books[1] = "PHY";
        System.out.println(books[1]);
    }
}

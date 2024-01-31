package org.example1;

import java.util.Date;

// reference types: class
// null is default value for reference types
public class SystemDefinedReferenceTypes {

    private static String s;
    public static void main(String[] args) {
        RuntimeException ex = new RuntimeException("Error happened");
        Date date = new Date();
        System.out.println(ex.toString()); // by default it calls toString()
        System.out.println(ex); // by default it calls toString()
        System.out.println(date);
        System.out.println(s);
    }
}

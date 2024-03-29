package org.example10;

import java.util.Arrays;

public class App9 {
    public static void main(String[] args) {
        m1(); // due to exception here below line wont be executed
        System.out.println("main complete");
    }

    public static void m1(){
        int[] arr = {10,11};
        try {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            throw new RuntimeException("array is not valid"); // finally block executes even it faces exception
        }
        finally {
            Arrays.fill(arr, 0);
            System.out.println("arrays filled in finally");
        }
       // System.out.println(Arrays.toString(arr));
    }
}

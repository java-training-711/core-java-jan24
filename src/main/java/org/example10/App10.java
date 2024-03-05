package org.example10;

import java.util.Arrays;

public class App10 {
    public static void main(String[] args) {
        m1(); // due to exception here below line wont be executed
        System.out.println("main complete");
    }

    public static void m1(){
        int[] arr = {10,11};
        try {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println("in try block");
            System.exit(0); // finally block wont executed due to this jvm exit
        }
        finally {
            Arrays.fill(arr, 0);
            System.out.println("arrays filled in finally");
        }
       // System.out.println(Arrays.toString(arr));
    }
}

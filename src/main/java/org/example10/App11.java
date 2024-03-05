package org.example10;

import java.util.Arrays;

public class App11 {
    public static void main(String[] args) {
        m1(); // due to exception here below line wont be executed
        System.out.println("main complete");
    }

    public static void m1(){
        int[] arr = {10,11};
        try {
            System.out.println("in try block");
            System.out.println(arr[0]);
            System.out.println(arr[2]);
        }
        catch (RuntimeException e){
            System.out.println(e);
            System.exit(0); // finally block wont executed due to this jvm exit
        }
        finally {
            Arrays.fill(arr, 0);
            System.out.println("arrays filled in finally");
        }
       // System.out.println(Arrays.toString(arr));
    }
}

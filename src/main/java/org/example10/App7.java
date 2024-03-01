package org.example10;

import java.util.Arrays;

public class App7 {
    public static void main(String[] args) {
        m1(); // due to exception here below line wont be executed
        System.out.println("main complete");
    }

    public static void m1(){
        int[] arr = {10,11};
        try {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
        } catch (RuntimeException e) {
            System.out.println("index not found");
        }
        finally {
            Arrays.fill(arr, 0);
        }
        System.out.println(Arrays.toString(arr));
    }
}

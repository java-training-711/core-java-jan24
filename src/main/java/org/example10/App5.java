package org.example10;

public class App5 {
    public static void main(String[] args) {
        m1();
        System.out.println("main complete");
    }

    public static void m1(){
        int[] arr = {10,11};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        try {
            System.out.println(arr[2]);
        } catch (RuntimeException e) {
            System.out.println("index not found");
        }
    }
}

package org.example10;

public class App4 {
    public static void main(String[] args) {
        m1(); // due to exception here below line wont be executed
        System.out.println("main complete");
    }

    public static void m1(){
        int[] arr = {10,11};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}

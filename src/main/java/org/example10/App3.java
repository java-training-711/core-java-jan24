package org.example10;

public class App3 {
    // when exception occurs, current execution thread stops if the exception not suppressed using catch block
    public static void main(String[] args) {
        m1();
    }

    public static void m1(){
        int[] arr = {10,11};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}

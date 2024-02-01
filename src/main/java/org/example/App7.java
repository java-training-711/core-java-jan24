package org.example;

public class App7 {

    static {
        m1();
//        m2(); // cant be called without using object as it is non-static method and accessing from static area
    }

    {
        this.m2();
        m1();
    }

    private static void m1(){

    }

    private void m2(){

    }
    public static void main(String[] args) {

    }
}

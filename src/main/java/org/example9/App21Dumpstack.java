package org.example9;

public class App21Dumpstack {

    public static void main(String[] args) {
        m1();
    }

    private static void m1(){
        m2();
    }
    private static void m2(){
        m3();
    }
    private static void m3(){
        System.out.println("Hello");
        Thread.dumpStack();
    }
}

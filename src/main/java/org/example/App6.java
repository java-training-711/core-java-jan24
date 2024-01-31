package org.example;

// static and non-static block2
public class App6 {

    // class loads only once
    static {
        System.out.println("static block 1");
        m2();
    }

    // every time object created
    {
        System.out.println("non static block 2");
        this.m1();
    }

    public static void main(String[] args) {
        new App6();
        System.out.println("-------------------------");
        new App6();
    }

    public void m1(){
        System.out.println("m1 invoked");
    }

    public static void m2(){
        System.out.println("m2 invoked");
    }

}

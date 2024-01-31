package org.example;

// static blocks
public class App3 {

    // class loaded to JVM
    // code that needs to execute automatically only once when class is loaded to JVM.
    // JVM invokes these static blocks during class loading sequentially

    static {
        System.out.println("static block 1");
    }

    static {
        System.out.println("static block 2");
    }

    public static void main(String[] args) {
      // no invocation to any method here
    }

    public static void m1(){
        System.out.println("static method m1()");
    }
}

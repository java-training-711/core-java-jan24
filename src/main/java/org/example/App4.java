package org.example;

// static blocks and static methods
// static methods can be called from static area
public class App4 {

    // class loaded to JVM
    // code that needs to execute automatically only once when class is loaded to JVM.
    // JVM invokes these static blocks during class loading sequentially

    static {
        System.out.println("static block 1");
        m1("ONE");
    }

    static {
        System.out.println("static block 2");
        m1("TWO");
    }

    public static void main(String[] args) {
        m1("THREE");
    }

    // static method
    public static void m1(String message) {
        System.out.println("m1() with message: "+ message);
    }
}

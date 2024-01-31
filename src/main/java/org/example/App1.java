package org.example;

// static and non-static methods and invocation
public class App1 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // access static method
        m1(); // because m1 and main both are in same class and static also
        App1.m1();

        // non-static method
        App1 myObject = new App1();
        myObject.m2();
    }
    // define method ? where ? inside class
    // must add access modifier
    // which type of method? static or non-static
    // what is the return datatype of method or void
    // name of method and its params or arguments
    public static void m1(){
        System.out.println("static method m1");
    }

    // dont use static keyword here. so it is non-static method
    public void m2(){
        System.out.println("non static method m2");
    }
}

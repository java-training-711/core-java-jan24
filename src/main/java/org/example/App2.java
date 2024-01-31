package org.example;

// multiple static and non-static methods and this keyword
public class App2 {
    public static void main(String[] args) {
        m1(10, "Hello");
    }

    // signature: name and parameters
    // same name and number of parameters should be different in order and type: overloading of methods
    // overloading is same for both static and non-static methods
    public static void m1(int x, String y){
        // number of line should not be more than 15
        System.out.println(x +" "+y);
        m1("Hello", 2003);
        m2();
        App2 app2 = new App2();
        System.out.println(app2);
        app2.m3();
    }


    public static void m1(String y, int x){
        System.out.println(y+ " " +x);
    }

    public static void m2(){
        System.out.println("m2 invoked");
    }

    public void m3(){
        // inside non-static area only you can use this keyword
        System.out.println(this+" m3 invoked");
        this.m4();
        m4();
    }

    public void m4(){
        System.out.println(this+" m4 invoked");
    }
}

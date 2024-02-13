package org.example4.cases;


/**
 * static methods never overridden
 * private methods also never overridden
 * public method can be overridden
 * protected method can be overridden
 * protected members inheritable to child class(any package) also.
 *
 * Using object reference:
 * public members accessible outside class/package
 * private members not accessible outside class
 * protected members not accessible outside class from different package
 * protected members accessible outside class from same package
 */
public class Example1 {

    private static class B extends A {
        @Override
        public void m1() {
            System.out.println("m1(): B");
        }

        public static void m2(){
            System.out.println("m2(): B");
        }

        @Override
        public void m3() {
            super.m3(); //m3:A
            System.out.println("m3(): B");
        }

        // private methods cant be overidden
//        @Override
        public void m4(){
            System.out.println("m4: B");
        }

        @Override
        protected void m5() {
           // super.m5();
            System.out.println("m5(): B");
        }
    }
    public static void main(String[] args) {
        A a = new B();
//        a = null;
       // a.m2(); // static it uses class name of reference variable
        A.m2();
        a.m1(); // m1 is non-static, so it uses object B.

        a.m3();

//        a.m4(); // private members cant be accessed outside class

        // protected acts like private outside package but you can override a protected method from outside package too
        a.m5();

    }
}

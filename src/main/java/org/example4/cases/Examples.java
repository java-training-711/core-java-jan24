package org.example4.cases;

public class Examples {

    private static interface  A{
        public int a = 10; // interface variables are final as well static variables, we camt re-initialize it
        public int b = 10;
        public int c = 100;
        public void m1();
        public void m2();

        // static methods if present in interface they must have body: java 8
        public static void m3() {

        }

        public static void m4() {

        }
    }

    private static class C1 implements A{
        @Override
        public void m1() {
//            a = 100;
        }

        @Override
        public void m2() {

        }

        public void m3(){

        }
    }

    // static methods cant be overridden? why ?
    // only non-static methods can be overridden
    private static abstract class C2 implements A{
        @Override
        public void m2() {
            System.out.println(this.getClass()+ "+_M2");
        }
    }

    private static class C3 extends  C2{
        @Override
        public void m1() {
            System.out.println(this.getClass()+"_M1");
        }
    }


    private static class Calculator{

        private int i;
        private int j;

        public Calculator(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int sum(){
            return this.i + this.j;
        }

    }


    public static void main(String[] args) {
        A a = new C1();
        a.m1();
        a.m2();
//        a.m3(); m3() is not part of A, so you cant invoke
        a = null;
        System.out.println(a.b); // null access to a static member wont give null pointer exception
        System.out.println(A.b);
//        a.m1(); // null access to a non-static member gives null pointer exception
        A.m3();
        A.m4();

        // this: object under invocation
        // reference = object
        A aa = new C3();
        aa.m1();
        aa.m2();

        Calculator c = new Calculator(10, 20); // state
        System.out.println(c.sum()); // behaviour depends on the state
    }
}

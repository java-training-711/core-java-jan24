package org.example3;

public class InheritanceExample1 {

    private static class A{
        public A() {
            System.out.println("parent class");
            System.out.println(this.getClass());
            System.out.println(this.hashCode());
        }
    }

    // invocation to super() or this() never creates a new object. so the hashCode is same.
    private static class B extends A{
        public B() {
            // super() : by default called during inheritance
            new A();
            System.out.println("child class");
            System.out.println(this.getClass());
            System.out.println(this.hashCode());
        }
    }

    public static void main(String[] args) {
        A a = new B();
    }
}

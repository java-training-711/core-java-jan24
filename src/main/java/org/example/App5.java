package org.example;

// non-static blocks

public class App5 {

    // execute per object instantiation
    {
        System.out.println("non static block 1");
        this.m4();
    }

    {
        System.out.println("non static block 2");
        this.m4();
    }

    public static void main(String[] args) {

        App5 myObjectVar1 = new App5();
        System.out.println("------------------------");
        App5 myObjectVar2 = new App5();
        System.out.println("------------------------");
        App5 myObjectVar3 = new App5();
        System.out.println(myObjectVar1);
        System.out.println(myObjectVar2);
        System.out.println(myObjectVar3);
    }

    public void m4(){
        System.out.println("m4 invoked");
    }
}

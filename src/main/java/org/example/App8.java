package org.example;

public class App8 {

    private static String sv="ONE";
    private String nsv="ONE_1";

    static {
        sv="TWO";
        m1();
    }

    {
        nsv = "TWO_2";
        this.m2();
    }

    private static void m1(){
        sv="THREE";
//        nsv="";
    }

    private void m2(){
        nsv ="THREE_3";
    }

    public static void main(String[] args) {
        System.out.println(sv);
        App8 app8 = new App8();
        System.out.println(app8.nsv);
    }
}

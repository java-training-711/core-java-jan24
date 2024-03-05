package org.example12;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Alex"); // mutable, thread safe with synchronized
        sb.append("Bell");
        System.out.println(sb.toString());
    }
}

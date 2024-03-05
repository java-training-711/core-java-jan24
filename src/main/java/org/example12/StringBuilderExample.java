package org.example12;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("Alex"); // mutable, not thread safe
        builder.append("Bell");

        System.out.println(builder.toString());
    }
}

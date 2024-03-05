package org.example12;

import java.util.Arrays;

public class StringExample {
    public static void main(String[] args) {
        String s1 = new String("Hello World"); // heap
        String s3 = new String("Hello World"); // heap
        String s2 = "Hello World"; // scp : string constant pool has unique strings
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1.intern() == s2.intern());
        System.out.println(s3.intern() == s1.intern());

        System.out.println(s1.substring(1));
        System.out.println(s1.substring(1, 3));
        System.out.println(s1.length());

        char[] ch = s1.toCharArray();
        System.out.println(Arrays.toString(ch));

        System.out.println(s1.indexOf('H'));
        System.out.println(s1.indexOf("World"));

        String s4 = "   ";
        System.out.println(s4.isBlank());
        System.out.println(s4.isEmpty());

        String s5 = "Alex";
        String s6 = new String(s5.getBytes());
        System.out.println(s6);

        String s7 = s5.concat("Bell"); // string is immutable , state is not going to change, thread safe without synchronized

        System.out.println(s5);
        System.out.println(s7);
    }
}

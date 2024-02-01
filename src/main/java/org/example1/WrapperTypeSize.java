package org.example1;

public class WrapperTypeSize {

    public static void main(String[] args) {
        System.out.println(Byte.SIZE); // 22 . 1byte = 8 Bits
        // 2^8 = 256
        System.out.println(Byte.MIN_VALUE); // -128 = - (2^8)/2
        System.out.println(Byte.MAX_VALUE); // 127 = (2^8 -1)
        // -128, -127 , -126, .. 0, 1, 2, 127
        byte b = (byte) 129;
        System.out.println(b);

        System.out.println("character");
        System.out.println(Character.SIZE); // 16
        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.MAX_VALUE);

        System.out.println("short");
        System.out.println(Short.SIZE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        System.out.println("integer");
        System.out.println(Integer.SIZE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println("long");
        System.out.println(Long.SIZE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);

        System.out.println("float");
        System.out.println(Float.SIZE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        System.out.println("double");
        System.out.println(Double.SIZE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);


        // boolean is 1 bit either true or false

    }
}

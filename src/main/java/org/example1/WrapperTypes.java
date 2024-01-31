package org.example1;

/***
 * System defined wrapper types are also reference types
 */
public class WrapperTypes {
    public static void main(String[] args) {
        char c = 'b';
        Character c1 = 'h';
        Character c2 = Character.valueOf('h');
        c = c1; // object type to its primitive type
        c1 = c; // primitive type to object type

        Integer i = new Integer(10);
         i = 100;

        Short s = 100;

        Byte byt = 123;

        Float fl = 23.4f;

        Long ln = 12345L;

        Double dd = 23.4d;

        Boolean bool= true;

    }
}

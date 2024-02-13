package org.example5.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

    // array: size iz fixe
    // collection fwk: as you add or remove elements , the collection can be adjusted dynamically
    // write
    // read
    // replace
    // remove

    // C: create, R: read. U: update, D; delete
    public static void main(String[] args) {
        // list
        // java.util.List

        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("Alex");
        list.add("Andrew");
        list.add("Ollie");

        System.out.println(list);

        // R: read
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        // U; replace
        list.set(0, "Jacob");
        System.out.println(list);

        // D: delete
        String removedValue = list.remove(0);
        System.out.println(removedValue);
        System.out.println(list);
    }
}

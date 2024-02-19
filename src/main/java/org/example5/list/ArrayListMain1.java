package org.example5.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Collection: List, Set
// Map
public class ArrayListMain1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(5);
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");
        names.add("John");

        Object[] namesArray = names.toArray();
        System.out.println(Arrays.toString(namesArray));

        List<Object> elements = new ArrayList<>();
        elements.add(10);
        elements.add(20);
        elements.add(30);
        elements.add(40);
        Integer[] intList = elements.toArray(new Integer[]{});
        System.out.println(Arrays.asList(intList));
    }
}

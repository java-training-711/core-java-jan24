package org.example5.set;

import java.util.*;

public class SetMain {
    public static void main(String[] args) {
        Map<Integer, String> dataMap = new HashMap<>();
        dataMap.put(101, "John");
        dataMap.put(102, "Alex");
        // in map keys are unique

        // in set elements are unique
        Set<Integer> set = new HashSet<>(); // internal HashMap
        set.add(101);
        set.add(102);
        set.add(101);

        // elements of set are internally the keys of a map

        Set<Integer> set1 = new LinkedHashSet<>(); // internal LinkedHashMap
        set1.add(101);
        set1.add(102);
        set1.add(101);

        // comparable or comparator acts on elements of set (which is internally keys of a map)
        Set<Integer> set2 = new TreeSet<>(); // internal TreeMap
        set2.add(101);
        set2.add(102);
        set2.add(101);
    }
}

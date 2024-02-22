package org.example5.set;

import java.util.*;

public class SetMain2 {
    public static void main(String[] args) {

        // in map keys are unique

        // in set elements are unique
        Set<Integer> set = new HashSet<>(); // internal HashMap
        set.add(101);
        set.add(102);
        set.add(101);
        set.add(103);

        System.out.println(set);

        System.out.println(set.contains(103));
        System.out.println(set.contains(104));
        List<Integer> list = new ArrayList<>();
        list.add(103);
        list.add(104);
        System.out.println(set.containsAll(list));

        System.out.println(set.add(103)); // false
        System.out.println(set.add(106)); // true

        System.out.println(set.size());
        System.out.println(set.remove(106)); // true
        System.out.println(set.remove(107)); // false

        for(int i: set){
            System.out.println(i);
        }

    }
}

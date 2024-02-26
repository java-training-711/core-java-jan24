package org.example7.task;

import java.util.*;

public class assignmentHashMap {
    public static void main(String[] args) {
//        iterableHashMap();
        weakHashmap();
    }

    private static void iterableHashMap() {
        IdentityHashMap<String, Integer> identifyHashMap = new IdentityHashMap<>();

        identifyHashMap.put("Josh", 10);
        identifyHashMap.put("Kelly", 20);
        identifyHashMap.put("Kevin", 30);
        identifyHashMap.put("John", 40);
        identifyHashMap.put("David", 50);

        System.out.println(identifyHashMap.size());
        System.out.println(identifyHashMap);

        Iterator<Map.Entry<String, Integer>> iterator = identifyHashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();

            System.out.println("Key: " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    private static void weakHashmap() {
        WeakHashMap<String, Integer> weakHashMap = new WeakHashMap<>();

        weakHashMap.put("Josh", 60);
        weakHashMap.put("Kelly", 70);
        weakHashMap.put("Kevin", 80);
        weakHashMap.put("John", 90);
        weakHashMap.put("David", 100);

        System.out.println(weakHashMap.size());
        System.out.println(weakHashMap);

        if(weakHashMap.containsKey("Kevin")) {
            System.out.println("Yes, this exists");
        }

        Set entrySet = weakHashMap.entrySet();
        System.out.println("Entry Set is: " + entrySet);

        Set keySet = weakHashMap.keySet();
        System.out.println("Key set is: " + keySet);
    }
}

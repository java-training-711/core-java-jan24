package org.example7.task;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Handler;

public class assignmentIteratorMap {
    public static void main(String[] args) {
        Map<String, Integer> array = new HashMap<>();

        array.put("Josh", 10);
        array.put("Kelly", 20);
        array.put("Kevin", 30);
        array.put("John", 40);
        array.put("David", 50);

        Iterator<Map.Entry<String, Integer>> iterator = array.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key is: " + entry.getKey() + ", Value is: " + entry.getValue());
        }
    }
}

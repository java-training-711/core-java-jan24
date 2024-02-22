package org.example5.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain5 {
    public static void main(String[] args) {
        // re-initialized vs modify using put remove replace
        final Map<Integer, String> dataMap = new HashMap<>();
//        dataMap = new HashMap<>();
        dataMap.put(101, "John");
        dataMap.put(102, "David");
        dataMap.put(103, "Tim");
        dataMap.put(104, "Tim");

        System.out.println(dataMap.keySet());
        System.out.println(dataMap.values());

        System.out.println(dataMap.containsKey(105)); // false
        System.out.println(dataMap.containsKey(104)); // true
        System.out.println(dataMap.containsValue("David"));
        System.out.println(dataMap.containsValue("David_1"));

        System.out.println(dataMap.remove(103)); // Tim
        System.out.println(dataMap);
        System.out.println(dataMap.remove(102, "David_1")); // false
        System.out.println(dataMap);

        System.out.println(dataMap.remove(102, "David")); // false
        System.out.println(dataMap);

        System.out.println(dataMap.replace(105, "Tim")); // null
        System.out.println(dataMap);

        System.out.println(dataMap.replace(101, "David")); // John
        System.out.println(dataMap);

        System.out.println(dataMap.isEmpty());
        dataMap.clear();
        System.out.println(dataMap.isEmpty());
    }
}

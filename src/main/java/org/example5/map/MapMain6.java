package org.example5.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapMain6 {
    public static void main(String[] args) {
        String input="ILoveMyCountry";
        /**
         * I = 1
         * L = 1
         * O = 1
         * V = 1
         * E = 1
         * M = 1
         * Y = 1
         * C = 1
         * O = 2
         */
        Map<Character, Integer> dataMap = new LinkedHashMap<>();
        char[] chars = input.toUpperCase().toCharArray();
        System.out.println(Arrays.toString(chars));

        for(char element: chars){
            if(dataMap.containsKey(element)){ // when element exists
                int count = dataMap.get(element);
                dataMap.put(element, count + 1);
                continue;
            }
            dataMap.put(element, 1);
        }

        System.out.println(dataMap);
        System.out.println(dataMap.get('Y'));

        System.out.println(dataMap.keySet());
        System.out.println(dataMap.entrySet());
        System.out.println(dataMap.containsValue(3));
        System.out.println(dataMap.getOrDefault("O", 2));
        System.out.println("...........");
        System.out.println(dataMap.remove('Y'));
        System.out.println(dataMap);

        System.out.println(dataMap.size());

    }
}

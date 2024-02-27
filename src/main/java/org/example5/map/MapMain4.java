package org.example5.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
This class has override methods of equals and hashcode
 */
public class MapMain4 {
    public static void main(String[] args) {

        MapKey mapKey1 = new MapKey(101);
        MapKey mapKey2 = new MapKey(102);
        MapKey mapKey3 = new MapKey(103);
        MapKey mapKey4 = new MapKey(101);

        System.out.println(mapKey1 == mapKey4); // false
        System.out.println(mapKey1.equals(mapKey4)); // true

        System.out.println(mapKey1 == mapKey2); // false
        System.out.println(mapKey1.equals(mapKey2)); // false

        System.out.println(mapKey1.hashCode()); // 1055
        System.out.println(mapKey4.hashCode()); // 1055

        Map<MapKey, String> dataMap = new HashMap<>();
        dataMap.put(mapKey1, "John"); // 1055 / 5
        dataMap.put(mapKey4, "David"); // 1055 / 5
        dataMap.put(mapKey3, "Tim");// 1058

        System.out.println(dataMap.size()); /// 2

        System.out.println(dataMap.get(mapKey1)); // David
        System.out.println(dataMap.get(mapKey4)); // David
        System.out.println(dataMap.get(mapKey3));
        MapKey mapKey5 = new MapKey(101); // 1059 // 9
        System.out.println(dataMap.get(mapKey5)); // null


    }

    private static class MapKey{
        private int id;

        public MapKey(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapKey mapKey = (MapKey) o;
            return id == mapKey.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}

package org.example5.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Map: not extends collection interface
 *
 * key , value
 *
 * implementation classes:
 *
 * HashMap: it uses hashing, insertion order of keys not maintained, not even sorted keys
 * LinkedHashMap: uses hashing + linked list, inserting order of keys maintained
 * TreeMap: not uses hashing, comparison logic using comparable or comparator. red black tree.
 */
public class MapMain1 {

    public static void main(String[] args) {
//        Map<Integer, String> dataMap = new HashMap<>();
//        dataMap.put(100, "John");
//        System.out.println(dataMap.get(100));

        Map<MapKey, String> dataMap = new HashMap<>(); // map keys are unique, value can be duplicate

        MapKey key = new MapKey(100); // 1055

        dataMap.put(new MapKey(104), "John");
        dataMap.put(new MapKey(102), "Alex");
        dataMap.put(key, "Alex"); // 1055, 1055 % 10 = 5th
        dataMap.put(new MapKey(101), "Tim"); // hashcode: 1022, 1022 % 10 = 2nd

        System.out.println("---------------------------------");
        System.out.println(dataMap.get(new MapKey(101))); // hashcode: 1044 , 1044 % 10 = 4th
        System.out.println(dataMap.get(key)); // 1055, 1055 % 10 = 5th

        System.out.println(dataMap.keySet());

        System.out.println("------------keyset iterate-------------");
        for(MapKey elementKey: dataMap.keySet()){
            System.out.println(dataMap.get(elementKey));
        }

        System.out.println("entry set iteration");
        System.out.println(dataMap.entrySet());

        for(Map.Entry<MapKey, String> item: dataMap.entrySet()){
            System.out.println(item.getKey()+" ---- "+item.getValue());
        }

    }

    private static class MapKey{

        private Integer id;

        public MapKey(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            MapKey mapKey = (MapKey) o;
            return Objects.equals(this.id, mapKey.id);
        }

        @Override
        public int hashCode() {
            System.out.println(this.id + ":"+ super.hashCode());
            int newHashCode = Objects.hash(id);
            System.out.println(this.id+"#"+newHashCode);

            return newHashCode;
        }

        @Override
        public String toString() {
            return "MapKey{" +
                    "id=" + id +
                    '}';
        }
    }
}

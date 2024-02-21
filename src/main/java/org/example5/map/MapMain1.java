package org.example5.map;

import java.util.*;

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
 *---------------------------- case1 : key is of type Integer ------------------
 * public boolean equals(Object o){
 *     return this == o;
 * }
 *
 * hash= key-> key % 10
 *
 * [1] : <101,JOHN>-<201, TIM>
 * [4] : <104,ALEX>
 *
 * Map<Integer,String> dataMap= new HashMap();
 * Integer#hashCode Integer#equals overridden
 *
 *  101, JOHN
 *  104, ALEX
 *  201, TIM
 *  101, GEORGE
 *
 * dataMap.get(201) // Tim
 * dataMap.get(301) // null
 *
 *  [1] : <101,GEORGE>-<201, TIM>
 *  [4] : <104,ALEX>
 *
 *  entry gets replaced when hahCode is same , and equals also say true for existing key and new key (101, 101)
 *  entry gets appended when hashCode is same but equals is false for existing key and new key (101, 201)
 * -------------------------------- case2 : custom MapKey but equals and hashCode from Object class ------------------
 *
 * class MapKey{
 *
 *     Integer id;
 *
 * }
 * #hashCode and #equals from Object class
 *
 * Map<MapKey,String> dataMap = new HashMap();
 * dataMap.put(new MapKey(101), "John"); // 1055 [5]
 * dataMap.put(new MapKey(102), "Alex"); // 1057 [7]
 * dataMap.put(new MapKey(101), "Tim"); // 1058  [8]
 *
 * dataMap.size() // 3
 *
 *
 * --------------------------- case3 : equals and hashCode overriden ------------------------
 * class MapKey{
 *
 *     Integer id;
 *
 *     public boolean equals(MapKey key){
 *         return this.id.compareTo(key.id);
 *     }
 *
 *     public int hashCode(){
 *         return Objects.hash(id);
 *     }
 *
 * }
 * #hashCode and #equals from MapKey class
 *
 * Map<MapKey,String> dataMap = new HashMap();
 * dataMap.put(new MapKey(101), "John"); // 101 [1]
 * dataMap.put(new MapKey(102), "Alex"); // 102 [2]
 * dataMap.put(new MapKey(101), "Tim"); // 101  [1]
 * dataMap.put(new MapKey(201), "George"); // 201  [1]
 *
 * [1] : 101, TIM - 201, GEORGE
 * [2] : 102, ALEX
 *
 *
 *
 * --------------------------- case4: hashCode only overridden ------------------------
 * class MapKey{
 *
 *     Integer id;
 *
 *     public int hashCode(){
 *         return Objects.hash(id);
 *     }
 *
 * }
 * #hashCode from MapKey and #equals from Object class ==
 *
 * Map<MapKey,String> dataMap = new HashMap();
 * dataMap.put(new MapKey(101), "John"); // 101 [1]
 * dataMap.put(new MapKey(102), "Alex"); // 102 [2]
 * dataMap.put(new MapKey(101), "Tim"); // 101  [1]
 * dataMap.put(new MapKey(201), "George"); // 201  [1]
 *
 * [1] : 10, JOHN
 * [2] : 102, ALEX
 *
 * -- after index conflict hashCode matched gives true(101, TIM): append
 *
 *  because p.key == key is false as it is reference comparison using ==
 *  so it goes to call equals method. as MapKey has not overriden equals so object class equals called that does
 *  again reference comparison using ==, which returns false
 *
 *  replace: if (p.hash == hash &&
 *                 ((k = p.key) == key || (key != null && key.equals(k))))
 *                 e = p;
 *
 * [1] : 101, JOHN - 101, TIM
 * [2] : 102, ALEX

 * -- after index conflict hash matched gives false(201, GEORGE) & equals gives false: append
 * #equals of object class that does reference comparison using ==
 * [1] : 101, JOHN - 101, TIM - 201, GEORGE
 * [2] : 102, ALEX
 *
 *
 *
 */
public class MapMain1 {

    public static void main(String[] args) {
//        Map<Integer, String> dataMap = new HashMap<>();
//        dataMap.put(100, "John");
//        System.out.println(dataMap.get(100));

        hashMapExample();

    //    linkedHashMapExample();

     //   treeMapExample();

//        treeMapExample_1();
    //    treeMapExample_2();
    }


    private static void treeMapExample(){ // entries<k,v> sorted by keys
        // compare(o1, o2)
        Comparator<Integer> customKeyComparator = (i1, i2)->{
            return i2.compareTo(i1);
        };

        Map<Integer, String> dataMap = new TreeMap<>(customKeyComparator); // the key must implement comparable#compareTo(o)
        dataMap.put(199, "John");
        dataMap.put(150, "Alex");
        dataMap.put(161, "David");
        dataMap.put(134, "Tim");

        System.out.println(dataMap);// 199, 161, 150, 134

        System.out.println(dataMap.get(134)); // Tim
        System.out.println(dataMap.get(156)); // null
    }

    private static void treeMapExample_1(){ // entries<k,v> sorted by keys

        Map<Integer, String> dataMap = new TreeMap<>(); // the key must implement comparable#compareTo(o)
        dataMap.put(199, "John");
        dataMap.put(150, "Alex");
        dataMap.put(161, "David");
        dataMap.put(134, "Tim");

        System.out.println(dataMap); // 134, 150, 161, 199
    }

    private static void treeMapExample_2(){
        // your key should implement comparable#compareTo
        // or
        // you constructor of treemap should take implementation comparator#compare
        Map<MapKey, String> dataMap = new TreeMap<>();

        MapKey key = new MapKey(100);

        dataMap.put(new MapKey(104), "John");
        dataMap.put(new MapKey(102), "Alex");
        dataMap.put(key, "Alex");
        dataMap.put(new MapKey(101), "Tim");

        System.out.println(dataMap);

        System.out.println("----------------------------");

        System.out.println(dataMap.get(new MapKey(101))); // 125
    }

    private static void linkedHashMapExample(){
        Map<Integer, String> dataMap = new LinkedHashMap<>();

        dataMap.put(199, "John"); // 9
        dataMap.put(150, "Alex"); // 0
        dataMap.put(161, "David");// 1
        dataMap.put(134, "Tim"); // 4

        System.out.println(dataMap); // linked list iteration
        System.out.println(dataMap.get(134)); // hashing
        // keySet
        // entrySet

        Map<Integer, String> dataMap1 = new LinkedHashMap<>();
        dataMap1.put(123, "George");
        dataMap1.put(135, "James");
        dataMap1.put(120, "Ahmed");

        dataMap.putAll(dataMap1);

        System.out.println(dataMap);
    }
    private static void hashMapExample() {
        Map<MapKey, String> dataMap = new HashMap<>(); // map keys are unique, value can be duplicate

        MapKey key = new MapKey(100); // 1055

        dataMap.put(new MapKey(104), "John");
        dataMap.put(new MapKey(102), "Alex");
        dataMap.put(key, "Alex"); // 1055, 1055 % 10 = 5th
        dataMap.put(new MapKey(101), "Tim"); // hashcode: 1022, 1022 % 10 = 2nd
        dataMap.put(new MapKey(101), "David"); // hashcode: 1022, 1022 % 10 = 2nd

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

    private static class MapKey implements Comparable<MapKey>{

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

        @Override
        public int compareTo(MapKey other) {
            System.out.println("sorting logic for key");
            MapKey current = this;
            return -current.id.compareTo(other.id);
        }
    }
}

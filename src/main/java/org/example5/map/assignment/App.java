package org.example5.map.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App {

    public static void main(String[] args) {
        Map<MapKey, String> dataMap = new HashMap<>();

        MapKey key = new MapKey(50);
        dataMap.put(new MapKey(55), "Josh");
        dataMap.put(new MapKey(60), "Shannon");
        dataMap.put(new MapKey(70), "Gary");
        dataMap.put(key, "David");
        System.out.println(dataMap.get(key));
        System.out.println("............");
        System.out.println(dataMap.get(new MapKey(50)));

        System.out.println(".............");
        for (MapKey elementKey: dataMap.keySet()) {
            System.out.println(dataMap.get(elementKey));
        }
        System.out.println(".....................");
        System.out.println(dataMap.entrySet());
        System.out.println(".....................");

        for (Map.Entry<MapKey, String> item: dataMap.entrySet()) {
            System.out.println(item.getKey()+"...... "+item.getValue());
        }
    }

    private static class MapKey {
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
            System.out.println(this.id + ":" + super.hashCode());
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

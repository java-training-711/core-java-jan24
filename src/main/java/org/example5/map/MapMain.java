package org.example5.map;


/**
 *
 *  using hashFunction it finds bucket index and return the element value from that.
 *  this makes search faster. 0(1)
 *
 *  but in array list it is 0(n)
 *
 * 102 | John </key|value>
 * <p>
 * <p>
 * 102 % 10 = 2
 * 103 % 10 = 3
 * 106 % 10 = 6
 * <p>
 * bucket[]
 */
public class MapMain {
    public static void main(String[] args) {
        System.out.println(102 % 10);

        Bucket buckets = new Bucket(10);
        buckets.add(106, "John");
        buckets.add(102, "Alex");
        buckets.add(103, "Tim");
        buckets.add(106, "Travis");
        System.out.println(buckets);
        System.out.println(buckets.get(106));
    }

    private static class Bucket {

        Dictionary[] dictionaries;

        public Bucket(int size) {
            dictionaries = new Dictionary[size];
        }

        public void add(Integer key, String value) {
            int index = hashFunction(key);
            Dictionary element = new Dictionary(key, value);
            dictionaries[index] = element;
        }

        private static int hashFunction(Integer key) {
            int index = key % 10;
            return index;
        }

        public String get(Integer key){
            int index = hashFunction(key);
            Dictionary element =dictionaries[index];
            return element.getValue();
        }
    }

    private static class Dictionary {
        private Integer key;
        private String value;

        public Dictionary(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}

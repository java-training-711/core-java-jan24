package org.example5.set;

import java.util.*;

public class SetMain3 {

    public static void main(String[] args) {
        Set<SetElement> hashSet = new HashSet<>();
        hashSet.add(new SetElement(101));
        hashSet.add(new SetElement(101));
        hashSet.add(new SetElement(102));
        System.out.println(hashSet);

        Set<SetElement> treeSet_1 = new TreeSet<>();
        treeSet_1.add(new SetElement(107));
        treeSet_1.add(new SetElement(105));
        treeSet_1.add(new SetElement(106));
        treeSet_1.add(new SetElement(101));
        treeSet_1.add(new SetElement(101));
        treeSet_1.add(new SetElement(102));

        System.out.println(treeSet_1);

        // Comparator#compare(e1,e2)
        Comparator<SetElement> comparator = (element1, element2)->{
            Integer a = element1.id;
            Integer b = element2.id;
            return -a.compareTo(b);
        };
        Set<SetElement> treeSet_2 = new TreeSet<>(comparator);
        treeSet_2.add(new SetElement(107));
        treeSet_2.add(new SetElement(105));
        treeSet_2.add(new SetElement(106));
        treeSet_2.add(new SetElement(101));
        treeSet_2.add(new SetElement(101));
        treeSet_2.add(new SetElement(102));

        System.out.println(treeSet_2);

        for(SetElement element: hashSet){
            System.out.println(element.id);
        }

        // hashSet
        // remove
        // retainAll
    }

    private static class SetElement implements Comparable<SetElement>{
        int id;

        public SetElement(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SetElement that = (SetElement) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public int compareTo(SetElement o) {
            Integer a = this.id;
            Integer b = o.id;
            return a.compareTo(b); // 0, 1, -1
        }

        @Override
        public String toString() {
            return "SetElement{" +
                    "id=" + id +
                    '}';
        }
    }
}

package org.example7.task;

import java.util.Arrays;
import java.util.Comparator;

public class AssignmentComparator {

    public static void main(String[] args) {
        compareReverse();
    }

    private static void compareReverse() {
        Integer[] array = {5, 15, 25, 20, 45, 10};
        Comparator<Integer> sortReverse = new sortDescend();
        Arrays.sort(array, sortReverse);
        System.out.println(Arrays.toString(array));

    }

    private static class sortDescend implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    }
}

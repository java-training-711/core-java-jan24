package org.example5.list;

public class IntArrayHW {
    public static void main(String[] args) {
        SumArray();
        maximumElement();
    }
    private static void SumArray() {
        Integer[] array = {10, 15};

        int sum = 0;
        for (int i=0; i < array.length; i ++ ) {
            int element = array[i];
            sum = sum + element;
            System.out.println(element);
        }
        System.out.println(sum);
    }

    private static void maximumElement() {
        Integer[] array = {2, 10, 25, 5, 8};

        int max = 0;
        for(int i = 0; i < array.length; i++ ) {
            int element = array[i];
            System.out.println(element);
            if (element > max ) {
                max = element;
            }
            System.out.println(max);
        }
    }
}

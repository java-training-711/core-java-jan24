package org.example5;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayMain {


    private static class Employee{

        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 5, 7, 9, 12};
      //  Arrays.sort(arr); // sort by natural order: asc
        Comparator<Integer> sortLogic = new SortDescending();
        Arrays.sort(arr, sortLogic);
        System.out.println(Arrays.toString(arr));

        String[] data = new String[4];
        System.out.println(Arrays.toString(data));
        Arrays.fill(data, "FILL SOME DATA");
        System.out.println(Arrays.toString(data));

        Employee e1 = new Employee(10, "John");
        Employee e2 = new Employee(11, "Alex");
        Employee e4 = new Employee(13, "John");
        Employee e3 = new Employee(12, "Andrew");

        Employee[] employees = {e1, e2, e4, e3};
        System.out.println(Arrays.toString(employees));
        Comparator<Employee> nameComparator = new SortName().reversed();
        Arrays.sort(employees, nameComparator);
        System.out.println(Arrays.toString(employees));

    }

    private static class SortName implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    // Comparator
    private static class SortDescending implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
                    // o2.compareTo(o1);
                    //compareCustom(o1, o2);
        }

        private int compareCustom(Integer o1, Integer o2){
            if(o1 == o2)
                return 0;
            if(o1 > o2)
                return -1;

            return 1;
        }
    }
}

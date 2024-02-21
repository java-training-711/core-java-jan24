package org.example5.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// sorting of elements
public class ArrayListMain2 {

    public static void main(String[] args) {
        Employee e1 = new Employee(100, "John");
        Employee e2 = new Employee(95, "ALex");
        Employee e3 = new Employee(106, "David");
        Employee e4 = new Employee(93, "ALex");
        Employee e5 = new Employee(107, "ALex");


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        //sortWithComparable(employeeList);
        Collections.sort(employeeList, new NameComparator().reversed());

  //      Collections.sort(employeeList, new NameWithIdComparator());

   //     Collections.sort(employeeList,(o1, o2)->{return o1.name.compareTo(o2.name);} );
     //   Collections.sort(employeeList, Comparator.comparing(o -> o.name));

        System.out.println(employeeList);
    }

    private static void sortWithComparable(List<Employee> employeeList) {
        Collections.sort(employeeList);// wont compile, because Employee class doesn't implements Comparable
        System.out.println(employeeList);
    }


    // when name is same, sort by id
    private static class NameWithIdComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            int result = o1.name.compareTo(o2.name);
            if(result == 0){ // 0, 1, -1, when name is same result will be 0
                return o1.id.compareTo(o2.id);
            }
            return result;
        }
    }

    private static class NameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return -o1.name.compareTo(o2.name);
        }
    }

    // .class is inside jar file
    private static class Employee implements Comparable<Employee>{

        private Integer id;
        private String name;

        public Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Employee param) {
            Employee current = this;
            return current.id.compareTo(param.id);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

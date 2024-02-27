package org.example5.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMain {

    // array: size iz fixe
    // collection fwk: as you add or remove elements , the collection can be adjusted dynamically
    // write
    // read
    // replace
    // remove

    public static void main(String[] args) {
        withStringElements();
        withEmployee();
    }

    private static void withEmployee(){
        Employee e1 = new Employee(1, "E1", "C1");
        Employee e2= new Employee(2, "E2", "C2");

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        Employee e3 = new Employee(2, "E11", "C11");
        System.out.println(employees.lastIndexOf(e3));
//        employees.remove(e3);
        System.out.println(employees);

        System.out.println("................");

//        Read:
        System.out.println(employees.get(0));
        System.out.println(employees.get(1));
        employees.add(e3);
        System.out.println(employees.get(2));
        System.out.println("...............");

//        Replace:
        employees.set(0, new Employee(4, "E4", "C4"));
        employees.set(1, new Employee(5, "E5", "C5"));
        employees.set(2, new Employee(6, "E6", "C6"));
        System.out.println(employees.get(0));
        System.out.println(employees.get(1));
        System.out.println(employees.get(2));
        System.out.println("....................");

//        delete:
        employees.remove(2);
        System.out.println(employees);
        System.out.println(".............");

        List<Employee> cleanEmployeeList = Arrays.asList(e1);
        employees.removeAll(cleanEmployeeList);
        System.out.println(employees);
        System.out.println("...............");

        List<Employee> retainEmployee = Arrays.asList(e1);
        employees.retainAll(retainEmployee);
        System.out.println(employees);
        System.out.println(".............");

        Employee e4 = new Employee(10, "E10", "C10");
        employees.add(e4);
        System.out.println(employees);
        employees.addAll(0, employees);
        System.out.println(employees.get(0));
        System.out.println("..........");
        System.out.println(employees);

    }
    private static class Employee{
        private int id;
        private String name;
        private String city;

        public Employee(int id, String name, String city) {
            this.id = id;
            this.name = name;
            this.city = city;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

        // object class equals compare the references using ==
        @Override
        public boolean equals(Object obj) { // this should be for content comparison not reference comparison
            System.out.println(obj);
            System.out.println(":"+this);
//            return super.equals(obj);
            Employee e =(Employee) obj;
            Integer id1 = this.getId();
            Integer id2 = e.getId();
            return id1.equals(id2);
        }
    }
    // C: create, R: read. U: update, D; delete
    public static void withStringElements() {
        // list
        // java.util.List

        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("Alex");
        list.add("Andrew");
        list.add("Ollie");
        list.add("Andrew");

        System.out.println(list);

        // R: read
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        // U; replace
        list.set(0, "Jacob");
        System.out.println(list);

        // D: delete
        String removedValue = list.remove(0);
        System.out.println(removedValue);
        System.out.println(list);

        boolean removed = list.remove("Andrew");
        System.out.println(removed);
        System.out.println(list);

        list.add("David");
        list.add("Tim");
        list.add("Josh");
        list.add("Mathew");

        System.out.println(list);

        List<String> cleanUpList = Arrays.asList("Alex", "David", "Ollie");
        list.removeAll(cleanUpList);
        System.out.println(list);

        List<String> retainList = Arrays.asList("Tim", "Josh", "James");
        list.retainAll(retainList); // retain only matching elements and remove all others
        System.out.println(list);

        list.add("James");
        list.add("Tim");
        System.out.println(list);

        String item = "Tim";
        boolean result =  list.contains(item);
        System.out.println(result);

        result = list.containsAll(retainList);
        System.out.println(result);

        List<String> names = Arrays.asList("Michale", "Hamis");
        list.addAll(names);
        System.out.println(list);

        list.set(0, "Tom");
        list.add(2, "Tom");
        System.out.println(list);
        list.addAll(3, names);
        System.out.println(list);


        System.out.println(list.size());
        System.out.println(list.isEmpty());

        int beginIndex = list.indexOf("Tom");
        System.out.println(beginIndex);
        int lastIndex = list.lastIndexOf("Tom");
        System.out.println(lastIndex);

        List<String> list1 = new ArrayList<>();
        System.out.println(list1.isEmpty());

        list.clear();
        System.out.println(list.isEmpty());

        list.addAll(retainList);
        System.out.println(list);

    }
}

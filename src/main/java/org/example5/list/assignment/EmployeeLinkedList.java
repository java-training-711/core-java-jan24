package org.example5.list.assignment;

import java.util.LinkedList;

public class EmployeeLinkedList {

    public static void main(String[] args) {
        withNewEmployeeLinkedList();
    }

    private static class Employee {
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

        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) { // this should be for content comparison not reference comparison
            System.out.println(obj);
            System.out.println(":" + this);
//            return super.equals(obj);
            Employee e= (EmployeeLinkedList.Employee) obj;
            Integer id1 = this.getId();
            Integer id2 = e.getId();
            return id1.equals(id2);
        }
    }

    private static void withNewEmployeeLinkedList() {
        Employee e1 = new Employee(1, "N1", "C1");
        Employee e2 = new Employee(2, "N2", "C2");
        Employee e3 = new Employee(3, "N3", "C3");
        Employee e4 = new Employee(4, "N4", "C4");
        Employee e5 = new Employee(5, "N5", "C5");
        Employee e6 = new Employee(6, "N6", "C6");

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(e1);
        employees.add(e2);
        employees.addFirst(e3);
        employees.add(e4);
        employees.addLast(e5);
        employees.add(e6);
        System.out.println(employees);

        System.out.println(employees.get(0));
        System.out.println(".............");

        employees.remove(); //removes the 1st index
        System.out.println(employees);
        System.out.println("..............");

        employees.removeLast(); //removes the last index
        System.out.println(employees);
        System.out.println("..............");

        System.out.println(employees.peekFirst()); //displays 1st index
        System.out.println(employees);
        System.out.println("................");

        System.out.println(employees.peekLast()); //displays last index
        System.out.println(employees);
        System.out.println("..............");

        System.out.println(employees.element()); //displays 1st index....element same as peek/peekFirst ?
        System.out.println(employees);
        System.out.println("..............");

        System.out.println(employees.poll()); //returns and removes 1st index
        System.out.println(employees);
        System.out.println("..............");

        System.out.println(employees.pop()); //displays 1st index
        System.out.println("...................");

        employees.push(e6);
    }
}


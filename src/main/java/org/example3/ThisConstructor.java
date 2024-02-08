package org.example3;

import org.example3.models.Employee;

public class ThisConstructor {
    public static void main(String[] args) {
        Employee e = new Employee("john doe");
        System.out.println(e.hashCode());
    }
}

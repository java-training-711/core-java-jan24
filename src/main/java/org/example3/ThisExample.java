package org.example3;

import org.example3.models.Student;

import java.util.UUID;

public class ThisExample {
    public static void main(String[] args) {
        Student s1 = new Student("ID1", "John Doe");
        System.out.println("--------------------------------------");
        Student s2 = new Student("ID2", "Alex Bell", s1);
    }
}

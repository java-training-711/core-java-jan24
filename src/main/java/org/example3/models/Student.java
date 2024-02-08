package org.example3.models;

// this keyword : non-static area
// this can access only non-static fields
// this refers to the current object
public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        display();
        this.display();
    }

    public Student(String id, String name, Student student){
        this.id = id;
        this.name = name;
        student.display(); // id of current object
        this.display();
    }

    public void display(){
        System.out.println(id);
        System.out.println(this.name);
    }
}

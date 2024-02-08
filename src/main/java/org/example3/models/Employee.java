package org.example3.models;

import java.util.UUID;

public class Employee {

    private String id;
    private String name;

    public Employee() {
        System.out.println(this.hashCode());
        this.id = UUID.randomUUID().toString();
    }

    public Employee(String name) {
       // new Employee();
        this(); // calling 0 param constructor,  this constructor should be first line of your constructor
        this.name = name;
        System.out.println(this.hashCode());
        if(this.id == null){
            throw new UnsupportedOperationException("id is not initialized");
        }
    }
}

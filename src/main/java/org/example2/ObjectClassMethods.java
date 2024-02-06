package org.example2;

import java.util.Arrays;

public class ObjectClassMethods {

    private static class Employee{
        public String name;
    }

    private class Student implements Cloneable{

        private char[] password;
        private int age;
        @Override
        public String toString() {
            return "STUDENT_CLASS "+" { age = "+age+"}";
        }

        @Override
        public boolean equals(Object obj) {
           // return super.equals(obj);
            Student param = (Student) obj;
            return this.age == param.age;
        }

//        @Override
//        protected void finalize() throws Throwable {
//           // super.finalize();
//            Arrays.fill(password, '*');
//            password = null;
//        }


        /**
         * AIRPORT:
         *   BOARDING PASS
         *     Sarojini: SouthWest Airlines
         * 	Kelly: SouthWest Airlines
         *
         *
         * 	public class Ticket{
         * 	  String airlineName;
         * 	  String passengerName;
         * 	    }
         *
         * 	Tikcet t = new Ticket("SouthWest Airlines");
         *
         * 	Ticket t1 = t.clone();
         * 	t1.passengerName = "sarojini";
         *
         * 	Ticket t2 = t.clone();
         * 	t2.passengerName = "kelly";
         *
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Student s = new Student();
            s.age = this.age + 2;
            return s;
           // return super.clone();
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e = new Employee();
        System.out.println(e.hashCode());
        System.out.println(e.toString());
        System.out.println(e.getClass());

        Employee e1 = new Employee();
        Employee e11 = e1;
        System.out.println(e11.equals(e1)); // true
        System.out.println(e11==e1); // true

        Employee e2 = new Employee();
        System.out.println(e1.equals(e2)); // false

        e1.name = "JOHN";
        e2.name = "JOHN";

        System.out.println(e1.equals(e2)); // false
        System.out.println(e1 == e2); // false

        ObjectClassMethods objectClassMethods = new ObjectClassMethods();
        Student student =  objectClassMethods. new Student();
        System.out.println(student.toString());

        Student s1 = objectClassMethods. new Student();
        s1.age = 20;

        Student s2 = objectClassMethods. new Student();
        s2.age = 20;

        System.out.println(s1.equals(s2)); // true after custom equals method

        Student s3 = (Student) s1.clone();
        System.out.println(s3.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s1.equals(s3));

    }
}

package org.example5.list;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class VectorMain {

    public static void main(String[] args) {
        Vector<Integer> nums = new Vector<>();
        nums.add(10);
        nums.add(0);
        nums.add(100);
        nums.add(20);
        nums.add(25);
        nums.add(30);
        System.out.println(nums);

        Enumeration<Integer> values = nums.elements();

        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }

        List<Integer> ages = new Vector<>();
        ages.add(10);
        ages.add(20);
        ages.add(60);

        Enumeration<Integer> ageValues = ((Vector<Integer>) ages).elements();
        while (ageValues.hasMoreElements()) {
            System.out.println(ageValues.nextElement());
        }

        Enumeration<Integer> ageValues1 = Collections.enumeration(ages);

        while (ageValues1.hasMoreElements()) {
            System.out.println(ageValues1.nextElement());
        }
    }
}

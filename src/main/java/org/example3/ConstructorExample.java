package org.example3;

import org.example3.models.Item;

public class ConstructorExample {
    public static void main(String[] args) {
        Item item1 = new Item();
        System.out.println(item1.getName());
        item1.setName("ITEM 3");
        System.out.println(item1.getName());
        System.out.println(item1.getId());
        System.out.println(item1.getPrice());
    }
}

package org.example3;

import org.example3.models.Item;

import java.util.UUID;

public class ObjectExample {
    public static void main(String[] args) {
        Item item1 = new Item(UUID.randomUUID().toString(), "ITEM 1", 100.34f);
        Item item2 = new Item(UUID.randomUUID().toString(), "ITEM 2", 110.34f);
    }
}

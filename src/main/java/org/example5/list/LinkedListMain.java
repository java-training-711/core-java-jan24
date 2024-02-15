package org.example5.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {

    public static void main(String[] args) {
        withBasicLinkedList();
        System.out.println("-----------------");
        withJavaLinkedList();
    }

    // application: v1 - v1.1 - v1.2 - v2 - v3
    // linked list:

    // array
      // [0, 1, 2, 3]
      // [0, 1, 2, 3, 4]
    private static void withJavaLinkedList(){
      LinkedList<String> names = new LinkedList<>();
      names.add("John");
      names.add("Alex");
      names.addFirst("David");
      names.addLast("Tim");

        System.out.println(names.getFirst());
        System.out.println(names.getLast());

        System.out.println(names.get(0));
        System.out.println(names);

        names.remove(); // removeFirst
        names.remove("John");
        names.removeLast();
        System.out.println(names);
        names.add("David");
        names.add("John");
        names.add("David");
        names.add("Alex");

        System.out.println(names);
        names.removeFirstOccurrence("Alex");
        names.removeLastOccurrence("David");
        System.out.println(names);
        System.out.println("------------------------");
        System.out.println(names.peek()); // peekFirst
        System.out.println(names.peekLast());
        System.out.println(names.peekFirst());
        System.out.println(names.element());// peekFirst
        System.out.println(names);
        System.out.println(names.poll()); // returns and removes fiorst element
        System.out.println(names.poll()); // returns and removes fiorst element
        System.out.println(names.poll()); // returns and removes fiorst element
        System.out.println(names.poll()); // returns and removes fiorst element if exist or else null
        System.out.println(names);
        System.out.println(names.peekLast());
//
//        removeAll, retainAll, set, clear, peek, peekLast, peekFirst,
//        indexdOf, lastIndexOff

        // do employee object
    }

    // n1: [value: 10 | next ] -> n2: [value: 20 | next]

    private static void withBasicLinkedList() {
        Node n1 = new Node();
        n1.value = 10;

        Node n2 = new Node();
        n2.value = 20;

        Node n3 = new Node();
        n3.value = 30;

        Node n11 = new Node();
        n11.value = 110;

        n1.next = n2;
        n2.next = n3;

        n1.next = n11;
        n11.next = n2;

        Node current = n1;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

    }

    private static class Node {
        int value;
        Node next;
    }
}

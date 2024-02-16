package org.example5.list;

public class CustomLinkedListMain {
    public static void main(String[] args) {
        withCustomLinkedList();
    }

    private static class CustomLinkedList {
        Node first;
        Node last;

        public void add(int value) {
            Node node = new Node();
            node.value = value;
            if (first == null) {
                first = node;
                last = node;
                return;
            }
            append(node);
        }

        private void append(Node node) {
            last.next = node;
            last = node;
        }
    }

    private static void withCustomLinkedList() {
        int[] arr = {10, 20, 30, 40, 50, 60};
        CustomLinkedList cl = new CustomLinkedList();
        for (int elem : arr) {
            cl.add(elem);
        }

        Node head = cl.first;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    private static class Node {
        int value;
        Node next;
    }
}

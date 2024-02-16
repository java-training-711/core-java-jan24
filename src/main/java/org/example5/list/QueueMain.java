package org.example5.list;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

    // first in first out (FIFO)
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);

        System.out.println(queue.poll()); // null
        System.out.println(queue.peek()); // null
        System.out.println(queue.element()); // null ?? when empty it throws exception
        System.out.println(queue.remove());
    }
}

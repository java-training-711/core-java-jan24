package org.example5.list;

import java.util.Stack;

public class StackMain {
    // push or pop
    // stack : last in first out (LIFO)
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack); // [10, 20] (20 is top)
        System.out.println(stack.peek()); // 20
        System.out.println(stack); // [10, 20] (20 is top)
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
        System.out.println(stack);// []

    //    System.out.println(stack.peek()); // EmptyStackException: Unchecked Exception as it extends RuntimeException
      //  System.out.println(stack.pop()); // EmptyStackException

        System.out.println(stack.empty());
    }
}

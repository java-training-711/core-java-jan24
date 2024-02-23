package org.example7;

public class Thread1 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);
    }
}

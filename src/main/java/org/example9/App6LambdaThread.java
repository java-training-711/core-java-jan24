package org.example9;

public class App6LambdaThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        Runnable r = ()->{
            System.out.println(Thread.currentThread());
        };
        Thread t = new Thread(r);
        t.start();
    }
}

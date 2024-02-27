package org.example9;

public class App6LambdaThread1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
//        Thread t = new Thread(()->{});
        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread());
        });
        t.start();
    }
}

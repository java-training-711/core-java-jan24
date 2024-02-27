package org.example9;

public class App1ThreadCreation {
    public static void main(String[] args) {
        // extend Thread class.
        // or
        // implement Runnable interface

        // both cases you have to override run()
        Worker1 worker1 = new Worker1();
        worker1.setName("WORKER_1");
        worker1.start();

        Worker2 worker2 = new Worker2();
        Thread th = new Thread(worker2);
        th.setName("WORKER_2");
        th.start();
    }

    private static class Worker1 extends Thread{

        // start method inherits from Thread class
        @Override
        public void run() {
//            super.run();
            Thread th = Thread.currentThread();
            State st = th.getState();
            System.out.println(th);
            System.out.println(st);
        }
    }

    public static class Worker2 implements Runnable{
        @Override
        public void run() {
            Thread th = Thread.currentThread();
            Thread.State st = th.getState();
            System.out.println(th);
            System.out.println(st);
        }
    }
}

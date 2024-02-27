package org.example9;

public class App2Sleep {
    public static void main(String[] args) throws InterruptedException {
        // extend Thread class.
        // or
        // implement Runnable interface

        // both cases you have to override run()
        Worker1 worker1 = new Worker1();
        worker1.setName("WORKER_1");
        System.out.println(worker1.getState());
        worker1.start();
        Thread.sleep(2000); // 2second
        System.out.println(worker1.getState());
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

}

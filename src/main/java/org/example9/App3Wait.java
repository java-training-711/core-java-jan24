package org.example9;

public class App3Wait {
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
        System.out.println(worker1.getState() + ":"+ Thread.currentThread() + ""+ Thread.currentThread().getState());
        Thread.sleep(3000); // 3 second
        System.out.println(worker1.getState());
        System.out.println("main complete");
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
            String name = "John";
            synchronized (name){ // wait method should be used inside synchronized area only
                try {
                    System.out.println("waiting at: "+System.currentTimeMillis());
                    name.wait(4000); // TIMED_WAITING 4 seconds, I wont use cpu for 4 seconds. after 4 seconds elapsed worker1 will be allocated cpu
                    //name.wait(); // WAITING forver,  I wont use cpu at all.
                    System.out.println("waiting done: "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

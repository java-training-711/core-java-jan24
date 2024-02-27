package org.example9;

public class App5Join {

    public static void main(String[] args) throws InterruptedException {
        Worker worker1 = new Worker("W1", 10);
        Worker worker2 = new Worker("W2", 20);

        worker1.start();
        worker1.join(); // main thread: I will wait until worker1 is done
        worker2.start();
        worker2.join();// main thread: I will wait until worker2 is done

        System.out.println("main completed");
    }

    private static class Worker extends Thread{
        private String threadName;
        private int num;

        public Worker( String threadName, int num) {
            super(threadName);
            this.threadName = threadName;
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(threadName+ ""+ Math.pow(num, 2));
            System.out.println(threadName+" completed");
        }
    }
}

package org.example9;

import java.util.HashSet;
import java.util.Set;

public class App19Deadlock {

    /**
     * Deadlock: both threads wont get the cpu or lock on shared object
     * 1. wait method is invoked, cpu released. Both threads are not notifying each other and will be in WAITING
     * state forever
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        IndexCounter counter = new IndexCounter();
        System.out.println("initial count: "+counter.getCount()); // 0

        OddPrinter oddPrinter = new OddPrinter("ODD", counter);
        EvenPrinter evenPrinter = new EvenPrinter("EVEN", counter);

        evenPrinter.start();
        oddPrinter.start();

        Thread.sleep(2000);
        System.out.println(evenPrinter.getState());
        System.out.println(oddPrinter.getState());

        System.out.println("main complete");
    }

    private static class OddPrinter extends Thread{

        private String name;
        private IndexCounter indexCounter;
        public OddPrinter(String name, IndexCounter indexCounter){
            super(name);
            this.name = name;
            this.indexCounter = indexCounter;
        }

        @Override
        public void run() {
           // super.run();
            synchronized (indexCounter){
                while(true){
                    if(indexCounter.getCount() >= 10){
                        break;
                    }
                    if(indexCounter.getCount() % 2 == 0){ // 4
                        indexCounter.print(); // 5
                       // System.out.println("notifying: "+Thread.currentThread());
                    }
                    try {
                      //  System.out.println("about to wait: "+Thread.currentThread());
                        indexCounter.wait();
                      //  System.out.println("notified: "+Thread.currentThread());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private static class EvenPrinter extends Thread{

        private String name;
        private IndexCounter indexCounter;
        public EvenPrinter(String name, IndexCounter indexCounter){
            super(name);
            this.name = name;
            this.indexCounter = indexCounter;
        }

        @Override
        public void run() {
            // super.run();
            synchronized (indexCounter){
                while(true){
                    if(indexCounter.getCount() >= 10){
                        break;
                    }
                    if(indexCounter.getCount() % 2 != 0){ // 3
                        indexCounter.print(); // 4
                      //  System.out.println("notifying: "+Thread.currentThread());
                    }
                    try {
                      //  System.out.println("about to wait: "+Thread.currentThread());
                        indexCounter.wait();
                      //  System.out.println("notified: "+Thread.currentThread());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    private static class IndexCounter {
        private int count = 0;

        private void increment() {
            count++;
        }

        public void print() {
            if (this.getCount() >= 10) {
                return;
            }
            increment();
            System.out.println(Thread.currentThread() + ":" + getCount());
        }

        public int getCount() {
            return count;
        }
    }
}

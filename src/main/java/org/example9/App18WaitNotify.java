package org.example9;

import java.util.HashSet;
import java.util.Set;

public class App18WaitNotify {

    public static void main(String[] args) {


        IndexCounter counter = new IndexCounter();
        System.out.println("initial count: "+counter.getCount()); // 0

        Set<String> states = new HashSet<>();


        OddPrinter oddPrinter = new OddPrinter("ODD", counter);
        EvenPrinter evenPrinter = new EvenPrinter("EVEN", counter);

        states.add(oddPrinter.getName()+":"+oddPrinter.getState());
        states.add(evenPrinter.getName()+":"+evenPrinter.getState());

        evenPrinter.start();
        oddPrinter.start();

        while(true){
            states.add(oddPrinter.getName()+":"+oddPrinter.getState());
            states.add(evenPrinter.getName()+":"+evenPrinter.getState());
            if(evenPrinter.getState() == Thread.State.TERMINATED && oddPrinter.getState() == Thread.State.TERMINATED){
                states.add(oddPrinter.getName()+":"+oddPrinter.getState());
                states.add(evenPrinter.getName()+":"+evenPrinter.getState());
                break;
            }

        }
        System.out.println(states);

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
                        indexCounter.notify();
                        break;
                    }
                    if(indexCounter.getCount() % 2 == 0){ // 4
                        indexCounter.print(); // 5
                        indexCounter.notify();
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
                        indexCounter.notify();
                        break;
                    }
                    if(indexCounter.getCount() % 2 != 0){ // 3
                        indexCounter.print(); // 4
                        indexCounter.notify();
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

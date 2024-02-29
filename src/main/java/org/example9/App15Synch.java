package org.example9;

import java.text.MessageFormat;

public class App15Synch {
    public static void main(String[] args) throws InterruptedException {


            Worker w1 = new Worker("W1");
            Worker w2 = new Worker("W2");
            Worker w3 = new Worker("W3");
            w1.start();
            w2.start();
            w3.start();

            Thread.sleep(2000);
    }

    private static class Worker extends Thread{
        private String name;

        private MessageFormat format = new MessageFormat("Current Thread: {0} and State: {1}");
        private MessageFormat format1 = new MessageFormat("NON_SYNCH Current Thread: {0} and State: {1}");
        public Worker(String name){
            super(name);
        }

        @Override
        public void run() {
            String result1 = format1.format(new Object[]{Thread.currentThread(), Thread.currentThread().getState()});
            String result = format.format(new Object[]{Thread.currentThread(), Thread.currentThread().getState()});

            // dont modify shared object state without synch
            m1_asynch(result1);
            int i=0; // 0, 1,2,3,4, 5

            // every object has only one lock
            // if a thread is holding a lock on object o, then other thread has to wait for first threads completion and release lock
            IndexCounter.incrementSynch(result);
             // release lock
        //   System.out.println(result+": count: "+indexCounter.getCount());
        }

        // which object lock: it is the object with which the method
        // here worker1 or worker2 object with which below method called.
        // as these are 2 dfnt objects they have 2 dfnt locks hence we may see data issue again.
        private synchronized void m2_synch(String result, int i) {
            System.out.println("------------------------------------------------");

        }

        private void m1_asynch(String result1) {
            int j = 0;
            while (j < 15) {
                IndexCounter.increment();
                System.out.println(result1 + ": count: " + IndexCounter.getCount());
                j++;
            }
        }


    }

    // [th1][th2][th1][th2][th2][th1]
    // single core cpu: at a time only one thread will execute its instruction
    // but that instruction execution happens quickly in nano seconds or in ms
    // and the cpu switches between threads frequently, due to which we think multiple threads are running
    private static class IndexCounter{
        private static int count=0;

        public static void increment(){
            count++; // one line.
            // fetch from memory previous count, (3ms) , taken away
            // increase the count, (2ms), taken away
            // write the count memory (4ms)
        }

        // static method uses class level lock. thr is only one class level lock per class.
        public static synchronized void incrementSynch(String result){
            int i=0;
            while (i < 15) {
               increment();
                System.out.println(result + ": count: " + getCount());
                i++;
            }
        }

        public static int getCount(){
            return count;
        }
    }
}

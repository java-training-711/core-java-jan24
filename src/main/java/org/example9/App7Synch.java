package org.example9;

import java.text.MessageFormat;

public class App7Synch {
    public static void main(String[] args) throws InterruptedException {

        int i = 0;
            IndexCounter indexCounter = new IndexCounter();
            System.out.println(indexCounter.getCount()); // 0

            Worker w1 = new Worker("W1", indexCounter);
            Worker w2 = new Worker("W2", indexCounter);
            w1.start();
            w2.start();

            // as we are no taking lock we will see inconsistent value of counter.
        // for example: w1 will set to 1 and release the cpu, it may next print 17.
        // during this time the w2 printed 2 to 16
        // next when w1 increments it will be from 16 to 17 instead 1 to 2
        // so w1 sees inconsistent data of counter as w1 and w2 shares teh same object
        // to fix this we will take lock on shared object. using synchronized keyword

            Thread.sleep(2000);
            System.out.println(indexCounter.getCount());
            i++;
    }

    private static class Worker extends Thread{
        private String name;
        private IndexCounter indexCounter;

        private MessageFormat format = new MessageFormat("Current Thread: {0} and State: {1}");
        public Worker(String name, IndexCounter indexCounter){
            super(name);
            this.indexCounter = indexCounter;
        }

        @Override
        public void run() {
           int i=0; // 0, 1,2,3,4, 5
            String result = format.format(new Object[]{Thread.currentThread(), Thread.currentThread().getState()});

                while (i < 15) {
                    indexCounter.increment();
                    System.out.println(result + ": count: " + indexCounter.getCount());
                    i++;
            }
        //   System.out.println(result+": count: "+indexCounter.getCount());
        }
    }

    // [th1][th2][th1][th2][th2][th1]
    // single core cpu: at a time only one thread will execute its instruction
    // but that instruction execution happens quickly in nano seconds or in ms
    // and the cpu switches between threads frequently, due to which we think multiple threads are running
    private static class IndexCounter{
        private int count=0;

        public void increment(){
            count++; // one line.
            // fetch from memory previous count, (3ms) , taken away
            // increase the count, (2ms), taken away
            // write the count memory (4ms)
        }

        public int getCount(){
            return count;
        }
    }
}

package org.example9;

public class App11Synch {
    public static void main(String[] args) throws InterruptedException {

        int i = 0;
            IndexCounter indexCounter = new IndexCounter();
            indexCounter.setStartTime(System.nanoTime());
            System.out.println(indexCounter.getCount()); // 0

            Worker w1 = new Worker("W1", indexCounter);
            Worker w2 = new Worker("W2", indexCounter);
            w1.start();
            w2.start();
            System.out.println(System.nanoTime());


    }

    private static class Worker extends Thread{
        private String name;
        private IndexCounter indexCounter;

        public Worker(String name, IndexCounter indexCounter){
            super(name);
            this.indexCounter = indexCounter;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(2000); // asynch
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // dont modify shared object state without synch

            // every object has only one lock
            // if a thread is holding a lock on object o, then other thread has to wait for first threads completion and release lock
            synchronized (indexCounter) { // taking lock
                try {

                    Thread.sleep(3000); // synch
                    indexCounter.diffTime(System.nanoTime());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } // release lock
        //   System.out.println(result+": count: "+indexCounter.getCount());
        }
    }

    // [th1][th2][th1][th2][th2][th1]
    // single core cpu: at a time only one thread will execute its instruction
    // but that instruction execution happens quickly in nano seconds or in ms
    // and the cpu switches between threads frequently, due to which we think multiple threads are running
    private static class IndexCounter{
        private int count=0;

        private Long time;

        public void increment(){
            count++; // one line.
            // fetch from memory previous count, (3ms) , taken away
            // increase the count, (2ms), taken away
            // write the count memory (4ms)
        }

        public void setStartTime(Long time) {
            this.time = time;
        }

        public Long getTime() {
            return time;
        }

        public void diffTime(Long currentTime){
            System.out.println(Thread.currentThread());
            System.out.println(currentTime - time);
        }

        public int getCount(){
            return count;
        }
    }
}

package org.example9;

public class App20Deadlock {

    /**
     * try to use jconsole or else below:
     * > jps
     *
     * > jstack pid
     *
     *
     Found one Java-level deadlock:
     =============================
     "EVEN":
     waiting to lock monitor 0x0000026839d1d450 (object 0x00000000821675f8, a org.example9.App20Deadlock$IndexCounter),
     which is held by "ODD"

     "ODD":
     waiting to lock monitor 0x0000026839d1d1b0 (object 0x0000000082167608, a java.lang.Class),
     which is held by "EVEN"

     Java stack information for the threads listed above:
     ===================================================
     "EVEN":
     at org.example9.App20Deadlock$EvenPrinter.run(App20Deadlock.java:78)
     - waiting to lock <0x00000000821675f8> (a org.example9.App20Deadlock$IndexCounter)
     - locked <0x0000000082167608> (a java.lang.Class for java.lang.String)
     "ODD":
     at org.example9.App20Deadlock$OddPrinter.run(App20Deadlock.java:51)
     - waiting to lock <0x0000000082167608> (a java.lang.Class for java.lang.String)
     - locked <0x00000000821675f8> (a org.example9.App20Deadlock$IndexCounter)

     Found 1 deadlock.
     */
    /**
     * Deadlock: both threads wont get the cpu
     * 1. wait method is invoked, cpu released. Both threads are not notifying each other and will be in WAITING
     * state forever
     * 2. t1: indexCounter, String.class . t2: String.class, indexCounter. Both threads will be having BLOCKED state
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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread()+": want to take lock on String.class");
                synchronized (String.class){
                    System.out.println("String class lock acquired by: "+currentThread());
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
            synchronized (String.class){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread()+": want to take lock on indexCounter");
                synchronized (indexCounter){
                    System.out.println("indexCounter lock acquired by: "+currentThread());
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

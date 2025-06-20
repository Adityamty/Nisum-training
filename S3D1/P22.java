public class CounterThreadDemo {
    static class Counter {
        int count = 0;
        void increment() {
            count++;
        }
        synchronized void safeIncrement() {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Without Synchronization ===");
        runCounterTest(false);

        System.out.println("\n=== With Synchronization ===");
        runCounterTest(true);
    }
    public static void runCounterTest(boolean useSync) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                if (useSync) {
                    counter.safeIncrement();
                } else {
                    counter.increment();
                }
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count: " + counter.count);
    }
}

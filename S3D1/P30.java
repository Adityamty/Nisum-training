import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(String threadName) {
        lock.lock();
        try {
            count++;
            System.out.println(threadName + " incremented count to: " + count);
            Thread.sleep(200); 
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

class WorkerThread extends Thread {
    private final SharedResource resource;
    private final String threadName;

    public WorkerThread(SharedResource resource, String threadName) {
        this.resource = resource;
        this.threadName = threadName;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.increment(threadName);
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new WorkerThread(resource, "Thread-1");
        Thread t2 = new WorkerThread(resource, "Thread-2");

        t1.start();
        t2.start();
    }
}

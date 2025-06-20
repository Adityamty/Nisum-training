import java.util.LinkedList;

class SharedBuffer {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); 
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notify(); 
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); 
        }
        int value = buffer.removeFirst();
        System.out.println("Consumed: " + value);
        notify(); 
        return value;
    }
}

class Producer extends Thread {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int value = 1;
        try {
            while (true) {
                buffer.produce(value++);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted.");
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(800); 
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}

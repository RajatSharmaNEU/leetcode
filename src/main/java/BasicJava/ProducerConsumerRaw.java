package BasicJava;

class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized int get() {
        System.out.println("Get- " + available);
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        notifyAll();
//        notify();
        return data;
    }

    public synchronized void put(int value) {
        System.out.println("Put- " + available);
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        notifyAll();
//        notify();
    }
}

class Producer implements Runnable {
    private SharedBufferA buffer;

    public Producer(SharedBufferA buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.put(i);
            System.out.println("Producer produced: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedBufferA buffer;

    public Consumer(SharedBufferA buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int value = buffer.get();
            System.out.println("Consumer consumed: " + value);
        }
    }
}

public class ProducerConsumerRaw {
    public static void main(String[] args) {
        SharedBufferA buffer = new SharedBufferA();
        Thread producerThread = new Thread(new ProducerA(buffer));
        Thread consumerThread = new Thread(new ConsumerA(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

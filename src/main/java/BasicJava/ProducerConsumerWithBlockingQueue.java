package BasicJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class SharedBufferA {
    private BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5); // Capacity of 5

    public int get() {
        int data = 0;
        try {
            data = buffer.take(); // Automatically blocks if the queue is empty
            System.out.println("Consumer consumed: " + data);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return data;
    }

    public void put(int value) {
        try {
            buffer.put(value); // Automatically blocks if the queue is full
            System.out.println("Producer produced: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ProducerA implements Runnable {
    private SharedBufferA buffer;

    public ProducerA(SharedBufferA buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.put(i);
            try {
                Thread.sleep(1000); // Simulate production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ConsumerA implements Runnable {
    private SharedBufferA buffer;

    public ConsumerA(SharedBufferA buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.get();
            try {
                Thread.sleep(1000); // Simulate consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerWithBlockingQueue {
    public static void main(String[] args) {
        SharedBufferA buffer = new SharedBufferA();
        Thread producerThread = new Thread(new ProducerA(buffer));
        Thread consumerThread = new Thread(new ConsumerA(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

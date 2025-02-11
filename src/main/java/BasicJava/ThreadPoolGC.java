package BasicJava;

import java.util.concurrent.*;

public class ThreadPoolGC {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                // Create some objects to trigger GC
                for (int j = 0; j < 10000; j++) {
                    new Object();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed. Triggering GC...");
        System.gc(); // Request GC (not guaranteed to run immediately)
    }
}


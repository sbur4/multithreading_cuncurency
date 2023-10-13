package cuncurency.thread_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }

        // Shutdown the thread pool
        executorService.shutdown();
    }
}
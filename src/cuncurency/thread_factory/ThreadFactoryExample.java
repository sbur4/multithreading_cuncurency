package cuncurency.thread_factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        ThreadFactory customThreadFactory = new CustomThreadFactory("CustomThread");

        // Create a thread pool using a custom thread factory
        ExecutorService executorService = Executors.newFixedThreadPool(2, customThreadFactory);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 4; i++) {
            executorService.submit(() -> {
                System.out.println("Task is running on thread " + Thread.currentThread().getName());
            });
        }

        // Shutdown the thread pool
        executorService.shutdown();
    }
}
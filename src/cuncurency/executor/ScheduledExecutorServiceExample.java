package cuncurency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        // Create a ScheduledExecutorService
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Schedule a task to run periodically
        Runnable task = () -> {
            System.out.println("Task is running...");
        };

        // Schedule the task to run every 1 second with an initial delay of 2 seconds
        executor.scheduleAtFixedRate(task, 2, 1, TimeUnit.SECONDS);
    }
}
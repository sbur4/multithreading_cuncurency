package cuncurency.delay_queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable task1 = () -> System.out.println("Task 1 executed.");
        Runnable task2 = () -> System.out.println("Task 2 executed.");

        executor.schedule(task1, 2, TimeUnit.SECONDS);
        executor.schedule(task2, 4, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
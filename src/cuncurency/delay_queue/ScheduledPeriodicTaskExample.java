package cuncurency.delay_queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPeriodicTaskExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Task executed at " + System.currentTimeMillis());

        executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);

        // Keep the program running for a while
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
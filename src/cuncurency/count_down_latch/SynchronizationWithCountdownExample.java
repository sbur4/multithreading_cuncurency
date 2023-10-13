package cuncurency.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class SynchronizationWithCountdownExample {
    public static void main(String[] args) throws InterruptedException {
        int workerCount = 3;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(workerCount);

        for (int i = 0; i < workerCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    startLatch.await(); // Wait for the start signal
                    System.out.println("Thread is working.");
                    finishLatch.countDown(); // Signal completion
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            thread.start();
        }

        // Start all worker threads simultaneously
        startLatch.countDown();

        finishLatch.await(); // Wait for all threads to finish
        System.out.println("All threads have finished.");
    }
}
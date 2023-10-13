package cuncurency.count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: Позволяет одному или нескольким потокам ожидать, пока несколько других потоков завершат выполнение.
 */
public class SimpleCountdownExample {
    public static void main(String[] args) throws InterruptedException {
        int count = 5;
        CountDownLatch latch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Thread started.");
                latch.countDown(); // Decrement the count
            });
            thread.start();
        }

        latch.await(); // Wait until the count becomes zero
        System.out.println("All threads have finished.");
    }
}
package cuncurency.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class WaitingForEventsWithCountdownExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch eventLatch = new CountDownLatch(1);

        // Simulate an external event
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some delay
                eventLatch.countDown(); // Signal the event
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        System.out.println("Waiting for the event...");
        eventLatch.await(); // Wait for the event to occur
        System.out.println("Event has occurred!");
    }
}
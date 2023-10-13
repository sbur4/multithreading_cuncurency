package cuncurency.future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulate some asynchronous task
            return 35;
        });

        // Attach a callback when the future completes
        future.thenAccept(result -> System.out.println("Task completed with result: " + result));

        // Wait for the future to complete (blocking)
        int result = future.get();
        System.out.println("Main thread: Task completed with result: " + result);
    }
}
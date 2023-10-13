package cuncurency.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future: Представляет результат асинхронной операции и позволяет управлять её выполнением и получением результата.
 */
public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            // Simulate some asynchronous task
            return 35;
        });

        // Wait for the future to complete (blocking)
        int result = future.get();
        System.out.println("Task completed with result: " + result);

        executor.shutdown();
    }
}
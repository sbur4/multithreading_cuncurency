package cuncurency.completion_service;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithCompletionServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        // Submit Callable tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            completionService.submit(() -> taskId * 10);
        }

        // Retrieve and print results
        for (int i = 0; i < 5; i++) {
            Future<Integer> result = completionService.take(); // Blocks until a result is available
            System.out.println("Result for Task " + (i + 1) + ": " + result.get());
        }

        executor.shutdown();
    }
}

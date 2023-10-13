package cuncurency.completion_service;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CompletionService: Предоставляет удобные методы для организации асинхронных вычислений и получения результатов в
 * порядке завершения.
 */
public class CompletionServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        // Submit tasks
        completionService.submit(() -> 1);
        completionService.submit(() -> 2);
        completionService.submit(() -> 3);

        // Retrieve results as they become available
        for (int i = 0; i < 3; i++) {
            Future<Integer> result = completionService.take(); // Blocks until a result is available
            System.out.println("Result: " + result.get());
        }

        executor.shutdown();
    }
}
package cuncurency.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceAndCompletableFutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->
                System.out.println("CompletableFuture thread 1 is running."), executorService);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() ->
                System.out.println("CompletableFuture thread 2 is running."), executorService);

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() ->
                System.out.println("CompletableFuture thread 3 is running."), executorService);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        try {
            combinedFuture.get(); // Wait for all threads to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
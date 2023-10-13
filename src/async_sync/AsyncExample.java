package async_sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncExample {
    public static void main(String[] args) {
        // Asynchronous Execution
        System.out.println("\nAsynchronous Execution:");
        long asyncStartTime = System.currentTimeMillis();
        doAsyncTasks();
        long asyncEndTime = System.currentTimeMillis();
        System.out.println("Asynchronous Execution Time: " + (asyncEndTime - asyncStartTime) + "ms");
    }

    private static void doAsyncTasks() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int taskNumber = i;
            Callable<String> task = () -> {
                System.out.println("Async Task " + taskNumber + " started.");
                // Simulate some work
                Thread.sleep(1000);
                System.out.println("Async Task " + taskNumber + " completed.");
                return "Task " + taskNumber + " result.";
            };
            futures.add(executorService.submit(task));
        }

        // Wait for all tasks to complete
        for (Future<String> future : futures) {
            try {
                future.get(); // Blocking call to get the result
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
package multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest3 {
    // do it in debug
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<Integer> task = () -> {
            Thread.sleep(3000); // Simulate some work
            return 35;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);

        try {
            Integer result = future.get(3, TimeUnit.SECONDS); // Wait for result, but with a timeout
            System.out.println("Task completed. Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Task did not complete within the timeout.");
        }

        executor.shutdown();
    }
}
package multithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Похож на Runnable, но может вернуть результат и генерировать исключения.
 */
public class CallableTest1 {
    // do it in debug
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> task = () -> {
            Thread.sleep(2000); // Simulate some work
            return 35;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);

        System.out.println("Task submitted. Waiting for result...");

        Integer result = future.get(); // Blocking call to get the result

        System.out.println("Task completed. Result: " + result);
        executor.shutdown();
    }
}
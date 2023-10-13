package multithreading.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest2 {
    // do it in debug
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> tasks = Arrays.asList(
                () -> 1,
                () -> 2,
                () -> 3
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = executor.invokeAll(tasks);

        for (Future<Integer> future : futures) {
            Integer result = future.get(); // Blocking call to get each result
            System.out.println("Task completed. Result: " + result);
        }

        executor.shutdown();
    }
}
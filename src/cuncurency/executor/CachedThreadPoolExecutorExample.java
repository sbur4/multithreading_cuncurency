package cuncurency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }
}
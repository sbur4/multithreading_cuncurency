package cuncurency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor: Определяет метод execute, который позволяет выполнять задачи асинхронно.
 * <p>
 * ExecutorService: Расширяет Executor и предоставляет методы для управления выполнением задач, такие как submit,
 * invokeAll, invokeAny, shutdown, и другие.
 * <p>
 * Executors: Предоставляет удобные методы для создания различных видов ExecutorService, например,
 * newFixedThreadPool, newCachedThreadPool, newSingleThreadExecutor, и другие.
 * <p>
 * A FixedThreadPoolExecutor creates a fixed-size thread pool. It's useful when you want to limit the number
 * of concurrent tasks.
 */
public class FixedThreadPoolExecutorExample {
    public static void main(String[] args) {
        int numThreads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName()));
        }

        executor.shutdown();
    }
}

package cuncurency.future;

import java.util.concurrent.FutureTask;

/**
 * FutureTask: Реализация интерфейса Future и Runnable, позволяет выполнить задачу асинхронно и получить результат.
 */
public class FutureTaskExample {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            // Simulate some asynchronous task
            return 35;
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        // Wait for the task to complete (blocking)
        int result = futureTask.get();
        System.out.println("Task completed with result: " + result);
    }
}
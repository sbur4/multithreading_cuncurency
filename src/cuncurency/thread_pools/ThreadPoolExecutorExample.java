package cuncurency.thread_pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor: Расширяет ExecutorService и предоставляет мощный механизм для управления пулами потоков.
 */
public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 10L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);

        for (int i = 0; i < 8; i++) {
            executor.execute(() -> {
                System.out.println("Task executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}

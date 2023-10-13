package cuncurency.thread_factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorWithCustomThreadFactory {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 10L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        ThreadFactory customThreadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "CustomThread-" + r.hashCode());
            }
        };

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue, customThreadFactory);

        for (int i = 0; i < 8; i++) {
            executor.execute(() -> {
                System.out.println("Task executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
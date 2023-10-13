package cuncurency.thread_pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorWithCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 10L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);

        Callable<String> task = () -> {
            return "Result from " + Thread.currentThread().getName();
        };

        Future<String> future = executor.submit(task);

        String result = future.get();
        System.out.println(result);

        executor.shutdown();
    }
}

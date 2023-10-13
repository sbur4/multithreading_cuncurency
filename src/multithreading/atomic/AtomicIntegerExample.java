package multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                int newValue = counter.incrementAndGet(); // Atomically increment by 1
                System.out.println(Thread.currentThread().getName() + ": Counter = " + newValue);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
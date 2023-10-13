package cuncurency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore - это счетчик, который управляет доступом к ресурсам. Он позволяет ограничивать количество потоков,
 * которым разрешен доступ к определенному ресурсу одновременно.
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Allow 2 threads to access a resource simultaneously

        Runnable task = () -> {
            try {
                semaphore.acquire();
                // Access the resource
                System.out.println(Thread.currentThread().getName() + " is using the resource.");
                Thread.sleep(2000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start(); // The third thread will be blocked until a permit is released.
    }
}
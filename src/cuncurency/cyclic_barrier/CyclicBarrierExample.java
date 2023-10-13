package cuncurency.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Класс CyclicBarrier: Позволяет набору потоков синхронизироваться в определенной точке выполнения перед продолжением работы.
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads);

        Runnable task = () -> {
            try {
                // Simulate some work
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
                barrier.await(); // Wait for other threads
                System.out.println(Thread.currentThread().getName() + " has passed the barrier.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(task).start();
        }
    }
}
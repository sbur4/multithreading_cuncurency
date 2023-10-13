package cuncurency.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RunnableAfterBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("All threads have reached the barrier. This is executed.");
        });

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

package cuncurency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1: Inside the critical section.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2: Inside the critical section.");
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();
    }
}
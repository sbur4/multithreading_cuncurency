package cuncurency.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();

        // Thread 1 (Writer)
        Thread thread1 = new Thread(() -> {
            lock.writeLock().lock();
            try {
                System.out.println("Thread 1 (Writer): Writing data.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        });

        // Thread 2 (Reader)
        Thread thread2 = new Thread(() -> {
            lock.readLock().lock();
            try {
                System.out.println("Thread 2 (Reader): Reading data.");
            } finally {
                lock.readLock().unlock();
            }
        });

        thread1.start();
        thread2.start();
    }
}
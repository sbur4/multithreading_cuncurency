package multithreading.synchronized_test;

/**
 * In this example, the increment() and getCount() methods are synchronized to ensure that only one thread can
 * access them at a time, preventing data corruption.
 */
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
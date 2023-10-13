package multithreading.lifecycle;

public class ThreadStatesTest2 {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                printThreadState("RUNNABLE (Thread 1)");
                try {
                    Thread.sleep(1500); // Simulate some work
                    lock.wait(); // Wait and release the lock
                    printThreadState("TERMINATED (Thread 1)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                printThreadState("RUNNABLE (Thread 2)");
                try {
                    Thread.sleep(1000); // Simulate some work
                    printThreadState("BLOCKED (Thread 2 - Waiting for Lock)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        printThreadState("NEW (Main Thread)");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(500); // Give threads time to start
            synchronized (lock) {
                lock.notify(); // Notify waiting thread (Thread 1)
            }
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThreadState("TERMINATED (Main Thread)");
    }

    private static void printThreadState(String stateName) {
        System.out.println("Thread state: " + stateName);
    }
}
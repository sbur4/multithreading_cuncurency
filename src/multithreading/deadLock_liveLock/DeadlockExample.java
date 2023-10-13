package multithreading.deadLock_liveLock;

/**
 * In this example, thread1 locks resource1 and waits for resource2, while thread2 locks resource2 and waits for
 * resource1. This leads to a deadlock condition.
 */
public class DeadlockExample {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {

                System.out.println("Thread 1: Holding resource 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                System.out.println("Thread 1: Waiting for resource 2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Acquired resource 2.");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {

                System.out.println("Thread 2: Holding resource 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                System.out.println("Thread 2: Waiting for resource 1...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Acquired resource 1.");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
package cuncurency.mutex;

/**
 * Mutex, или взаимное исключение, представляет собой механизм, который позволяет только одному потоку одновременно
 * получать доступ к ресурсу, чтобы избежать конфликтов при параллельном доступе.
 */
public class MutexExample {
    private static final Object mutex = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (mutex) {
                // Access the resource protected by the mutex
                System.out.println(Thread.currentThread().getName() + " is using the resource.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start(); // Only one thread can access the resource at a time.
    }
}
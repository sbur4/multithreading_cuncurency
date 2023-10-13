package cuncurency.monitor;

/**
 * Monitor - это более абстрактное понятие, которое описывает механизмы синхронизации и организации потоков в
 * многозадачной среде. В Java, synchronized блоки и методы реализуют мониторы, обеспечивая взаимное исключение.
 */
public class MonitorExample {
    private static final Object monitor = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (monitor) {
                // Access the resource protected by the monitor
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
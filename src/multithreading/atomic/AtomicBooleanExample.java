package multithreading.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {
    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(true);

        Runnable task1 = () -> {
            while (flag.get()) {
                System.out.println("Task 1 is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable task2 = () -> {
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
                flag.set(false); // Stop task1
                System.out.println("Task 2 set the flag to false.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
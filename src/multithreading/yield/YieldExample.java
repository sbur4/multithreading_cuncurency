package multithreading.yield;

public class YieldExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                Thread.yield(); // Suggest to yield the CPU
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
                Thread.yield(); // Suggest to yield the CPU
            }
        });

        thread1.start();
        thread2.start();
    }
}
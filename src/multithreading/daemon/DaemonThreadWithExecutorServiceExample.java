package multithreading.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadWithExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true); // Set as daemon thread
            return thread;
        });

        executor.execute(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Main thread exiting.");
    }
}
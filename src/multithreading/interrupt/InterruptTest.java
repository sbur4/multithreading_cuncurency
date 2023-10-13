package multithreading.interrupt;

public class InterruptTest {
    public static void main(String[] args) {
        Thread workerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Working...");
            }
            System.out.println("Thread interrupted. Cleaning up...");
        });

        workerThread.start();

        try {
            System.out.println("Sleep...");
            Thread.sleep(50); // Sleep for 3(3000) seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        workerThread.interrupt(); // Interrupt the worker thread
    }
}
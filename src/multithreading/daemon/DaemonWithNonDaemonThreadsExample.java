package multithreading.daemon;

public class DaemonWithNonDaemonThreadsExample {
    public static void main(String[] args) {
        Thread nonDaemonThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Non-daemon thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set as daemon thread
        daemonThread.start();
        nonDaemonThread.start();

        System.out.println("Main thread exiting.");
    }
}
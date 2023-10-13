package multithreading.lifecycle;

public class ThreadStatesTest1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            printThreadState("RUNNABLE");
            try {
                Thread.sleep(1000); // Simulate some work
                printThreadState("TIMED_WAITING (Sleeping)");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        printThreadState("NEW");

        thread.start();

        try {
            thread.join(); // Wait for the thread to finish
            printThreadState("TERMINATED");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printThreadState(String stateName) {
        System.out.println("Thread state: " + stateName);
    }
}
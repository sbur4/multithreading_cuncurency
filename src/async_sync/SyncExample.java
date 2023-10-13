package async_sync;

public class SyncExample {
    public static void main(String[] args) {
        // Synchronous Execution
        System.out.println("Synchronous Execution:");
        long syncStartTime = System.currentTimeMillis();
        doSyncTasks();
        long syncEndTime = System.currentTimeMillis();
        System.out.println("Synchronous Execution Time: " + (syncEndTime - syncStartTime) + "ms");
    }

    private static void doSyncTasks() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Sync Task " + i + " started.");
            // Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sync Task " + i + " completed.");
        }
    }
}
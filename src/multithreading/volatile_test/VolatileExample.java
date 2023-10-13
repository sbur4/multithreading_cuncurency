package multithreading.volatile_test;

public class VolatileExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread writerThread = new Thread(() -> {
            resource.toggleFlag();
            System.out.println("Flag set to true");
        });

        Thread readerThread = new Thread(() -> {
            while (!resource.isFlag()) {
                // Busy-wait until the flag is true
            }
            System.out.println("Flag is now true");
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
package multithreading.wait_notify;

public class SharedResource {
    private int data;
    private boolean produced = false;

    public synchronized void produce() {
        while (produced) {
            try {
                wait(); // Wait for the consumer to consume
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = (int) (Math.random() * 10);
        System.out.println("Produced: " + data);
        produced = true;
        notify(); // Notify the consumer to consume
    }

    public synchronized void consume() {
        while (!produced) {
            try {
                wait(); // Wait for the producer to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + data);
        produced = false;
        notify(); // Notify the producer to produce
    }
}
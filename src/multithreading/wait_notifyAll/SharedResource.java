package multithreading.wait_notifyAll;

public class SharedResource {
    private int data;
    private int producersWaiting = 0;
    private int consumersWaiting = 0;
    private boolean produced = false;

    public synchronized void produce() {
        producersWaiting++;
        while (consumersWaiting > 0 || produced) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        producersWaiting--;
        data = (int) (Math.random() * 10);
        System.out.println("Produced: " + data);
        produced = true;
        notifyAll();
    }

    public synchronized void consume() {
        consumersWaiting++;
        while (producersWaiting > 0 || !produced) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        consumersWaiting--;
        System.out.println("Consumed: " + data);
        produced = false;
        notifyAll();
    }
}
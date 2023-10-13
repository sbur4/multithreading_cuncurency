package multithreading.wait_notify;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.produce();
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.consume();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
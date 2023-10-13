package multithreading.wait_notifyAll;

public class MultipleProducersConsumersExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    sharedResource.produce();
                }
            }).start();

            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    sharedResource.consume();
                }
            }).start();
        }
    }
}
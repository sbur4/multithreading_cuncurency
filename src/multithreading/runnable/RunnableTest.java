package multithreading.runnable;

public class RunnableTest {
    public static void main(String[] args) {
        ThreadFirst runnableFirst = new ThreadFirst();
        Thread threadFirst = new Thread(runnableFirst);
        threadFirst.start();

        ThreadSecond runnableSecond = new ThreadSecond();
        Thread threadSecond = new Thread(runnableSecond, "Second");
        threadSecond.start();
    }

    private static class ThreadFirst implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("ThreadFirst: " + i);
            }
        }
    }

    private static class ThreadSecond implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread is running.");
        }
    }
}
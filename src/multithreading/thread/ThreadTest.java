package multithreading.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread threadFirst = new ThreadFirst();
        threadFirst.start();

        Thread threadSecond = new ThreadSecond("Second");
        threadSecond.start();

        Runnable myRunnable = () -> System.out.println("Thread using lambda is running.");
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    private static class ThreadFirst extends Thread {
        @Override
        public void run() {
            System.out.println(getName()); // Thread-0
            for (int i = 1; i <= 10; i++) {
                System.out.println("ThreadFirst: " + i);
            }
        }
    }

    private static class ThreadSecond extends Thread {
        public ThreadSecond(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is running.");
        }
    }
}
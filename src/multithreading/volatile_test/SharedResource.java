package multithreading.volatile_test;

/**
 * In this example, the flag variable is declared as volatile, ensuring that changes made by one thread are visible
 * to other threads. This is useful for signaling between threads.
 */
public class SharedResource {
    private volatile boolean flag = false;

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
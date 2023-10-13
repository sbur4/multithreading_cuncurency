package multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Increment the atomic integer atomically
        int newValue = atomicInt.incrementAndGet();
        System.out.println("Incremented Value: " + newValue);

        // Decrement the atomic integer atomically
        newValue = atomicInt.decrementAndGet();
        System.out.println("Decremented Value: " + newValue);

        // Add a specific value atomically
        int addValue = 5;
        newValue = atomicInt.addAndGet(addValue);
        System.out.println("After Adding " + addValue + ": " + newValue);

        // Compare and set the value if it matches the expected value
        int expectedValue = 5;
        int updatedValue = 10;
        boolean updated = atomicInt.compareAndSet(expectedValue, updatedValue);
        System.out.println("Compare and Set Result: " + updated);

        // Get the current value
        int currentValue = atomicInt.get();
        System.out.println("Current Value: " + currentValue);
    }
}
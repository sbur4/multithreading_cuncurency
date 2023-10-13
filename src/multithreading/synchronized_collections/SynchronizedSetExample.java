package multithreading.synchronized_collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SynchronizedSetExample {
    public static void main(String[] args) {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());

        // Add elements in a synchronized manner
        synchronized (set) {
            set.add("X");
            set.add("Y");
            set.add("Z");
        }

        // Iterating over the synchronized set
        synchronized (set) {
            for (String item : set) {
                System.out.println(item);
            }
        }
    }
}
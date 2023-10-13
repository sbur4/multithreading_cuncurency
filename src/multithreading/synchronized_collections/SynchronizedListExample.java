package multithreading.synchronized_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListExample {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        // Add elements in a synchronized manner
        synchronized (list) {
            list.add("A");
            list.add("B");
            list.add("C");
        }

        // Iterating over the synchronized list
        synchronized (list) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }
}
package multithreading.synchronized_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        // Add key-value pairs in a synchronized manner
        synchronized (map) {
            map.put("One", 1);
            map.put("Two", 2);
            map.put("Three", 3);
        }

        // Iterating over the synchronized map
        synchronized (map) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
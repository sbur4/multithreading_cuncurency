package cuncurency.phaser;

import java.util.concurrent.Phaser;

public class PhaserSynchronizationExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // Create a Phaser with 3 parties (threads)

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is ready.");
                phaser.arriveAndAwaitAdvance(); // Threads wait here until all are ready
                System.out.println(Thread.currentThread().getName() + " continues.");
            }).start();
        }
    }
}
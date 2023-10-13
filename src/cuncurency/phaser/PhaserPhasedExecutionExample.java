package cuncurency.phaser;

import java.util.concurrent.Phaser;

public class PhaserPhasedExecutionExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // Create a Phaser with 3 parties (threads)

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is in phase 1.");
                phaser.arriveAndAwaitAdvance(); // Wait for all threads to complete phase 1

                System.out.println(Thread.currentThread().getName() + " is in phase 2.");
                phaser.arriveAndAwaitAdvance(); // Wait for all threads to complete phase 2

                System.out.println(Thread.currentThread().getName() + " is done.");
                phaser.arriveAndDeregister(); // Deregister from the Phaser
            }).start();
        }
    }
}

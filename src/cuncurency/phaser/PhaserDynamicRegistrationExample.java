package cuncurency.phaser;

import java.util.concurrent.Phaser;

public class PhaserDynamicRegistrationExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Create a Phaser with 1 party (main thread)

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " is working.");
            phaser.arriveAndAwaitAdvance(); // Wait for all threads to synchronize here

            System.out.println(Thread.currentThread().getName() + " is done.");
            phaser.arriveAndDeregister(); // Deregister from the Phaser
        };

        new Thread(worker).start();
        new Thread(worker).start();

        // Main thread also participates
        System.out.println(Thread.currentThread().getName() + " is working.");
        phaser.arriveAndAwaitAdvance(); // Wait for all threads to synchronize here

        System.out.println(Thread.currentThread().getName() + " is done.");
        phaser.arriveAndDeregister(); // Deregister from the Phaser
    }
}

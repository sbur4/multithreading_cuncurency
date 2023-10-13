package cuncurency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread threadA = new Thread(() -> {
            try {
                String dataToSend = "Hello from ThreadA";
                System.out.println("ThreadA: Sending data - " + dataToSend);
                String receivedData = exchanger.exchange(dataToSend);
                System.out.println("ThreadA: Received data - " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                String dataToSend = "Hello from ThreadB";
                System.out.println("ThreadB: Sending data - " + dataToSend);
                String receivedData = exchanger.exchange(dataToSend);
                System.out.println("ThreadB: Received data - " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
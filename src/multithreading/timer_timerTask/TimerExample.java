package multithreading.timer_timerTask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // Create a TimerTask to be scheduled
        TimerTask task = new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                count++;
                System.out.println("Task executed " + count + " times.");

                if (count >= 5) {
                    System.out.println("Task completed. Stopping the timer.");
                    cancel(); // Stop the timer after the task runs 5 times
                }
            }
        };

        // Schedule the TimerTask to run every 1000 milliseconds (1 second)
        timer.schedule(task, 0, 1000);
    }
}
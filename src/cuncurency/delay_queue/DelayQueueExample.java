package cuncurency.delay_queue;

import java.util.concurrent.DelayQueue;

/**
 * Задачи с отложенным выполнением (Delayed Tasks): Вы можете использовать DelayQueue для выполнения определенных задач
 * или действий после задержки. Например, выполнение задачи через определенное количество времени, планирование задач в
 * будущем и т. д.
 * <p>
 * Управление временными данными: Этот класс может быть полезен, когда у вас есть данные, которые становятся доступными
 * только после истечения определенного времени. Например, кеширование данных с автоматическим обновлением после определенного времени.
 * <p>
 * Таймеры и планировщики: DelayQueue может использоваться для создания таймеров и планировщиков, которые выполняют
 * определенные задачи по истечении времени.
 */
public class DelayQueueExample {
    public static void main(String[] args) {
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();

        // Schedule tasks with different delays
        delayQueue.offer(new DelayedTask("Task 1", 2000)); // Delay of 2 seconds
        delayQueue.offer(new DelayedTask("Task 2", 4000)); // Delay of 4 seconds
        delayQueue.offer(new DelayedTask("Task 3", 3000)); // Delay of 3 seconds

        while (!delayQueue.isEmpty()) {
            try {
                DelayedTask task = delayQueue.take();
                System.out.println(task.getName() + " executed at " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
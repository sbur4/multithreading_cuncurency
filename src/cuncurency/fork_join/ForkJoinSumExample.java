package cuncurency.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join Framework (Фреймворк "Разделить и властвовать") в Java предназначен для параллельной обработки задач,
 * особенно рекурсивных задач, которые могут быть разделены на подзадачи и выполнены параллельно. Этот фреймворк является
 * частью Java Concurrency Framework и предоставляет удобные средства для реализации параллельных вычислений.
 */
public class ForkJoinSumExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        int result = forkJoinPool.invoke(new SumTask(array, 0, array.length));

        System.out.println("Sum: " + result);
    }

    static class SumTask extends RecursiveTask<Integer> {
        private int[] array;
        private int start;
        private int end;

        SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 2) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                leftTask.fork();
                int rightResult = rightTask.compute();
                int leftResult = leftTask.join();

                return leftResult + rightResult;
            }
        }
    }
}
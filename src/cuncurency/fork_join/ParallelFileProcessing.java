package cuncurency.fork_join;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelFileProcessing {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        long totalSize = forkJoinPool.invoke(new FileSizeTask(new File(directoryPath)));

        System.out.println("Total size: " + totalSize + " bytes");
    }

    static class FileSizeTask extends RecursiveTask<Long> {
        private final File file;

        FileSizeTask(File file) {
            this.file = file;
        }

        @Override
        protected Long compute() {
            if (file.isFile()) {
                return file.length();
            } else if (file.isDirectory()) {
                File[] children = file.listFiles();
                if (children != null) {
                    long totalSize = 0;
                    for (File child : children) {
                        FileSizeTask task = new FileSizeTask(child);
                        task.fork();
                        totalSize += task.join();
                    }
                    return totalSize;
                }
            }
            return 0L;
        }
    }
}
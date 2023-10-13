package cuncurency.thread_factory;

import java.util.concurrent.ThreadFactory;

class CustomThreadFactory implements ThreadFactory {
    private final String threadNamePrefix;

    public CustomThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadNamePrefix + "-" + thread.getId());
        return thread;
    }
}
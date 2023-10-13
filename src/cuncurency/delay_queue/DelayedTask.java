package cuncurency.delay_queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Delayed {
    private final String name;
    private final long executeTime;

    DelayedTask(String name, long delayMillis) {
        this.name = name;
        this.executeTime = System.currentTimeMillis() + delayMillis;
    }

    public String getName() {
        return name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = executeTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        long diff = this.getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS);
        return Long.compare(diff, 0);
    }

}

package school.sorokin.javacore.multithreading.lesson2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter{

    private AtomicInteger visitCount = new AtomicInteger();

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        visitCount.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        return visitCount.get();
    }
}

package school.sorokin.javacore.multithreading.lesson2;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter{

    private int visitCount;

    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void incrementVisitCount() {
        try {
            lock.lock();
            Thread.sleep(100);
            visitCount++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public int getVisitCount() {
        return visitCount;
    }
}

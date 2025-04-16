package school.sorokin.javacore.multithreading.lesson2;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor {

    private SiteVisitCounter siteVisitCounter;
    private List<Thread> threadList;
    private long startTime;
    private long endTime;

    public MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
        threadList = new ArrayList<>();
    }

    public void visitMultithread(int numOfThreads){
        startTime = System.currentTimeMillis();


        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(() -> siteVisitCounter.incrementVisitCount());
            thread.start();
            threadList.add(thread);
        }
    }

    public void waitUntilAllVisited(){
        for (Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        endTime = System.currentTimeMillis();
    }

    public double getTotalTimeOfHandling(){
        return  (double) (endTime - startTime) / 1000;
    }

    /**
     * 10 потоков
     * AtomicIntegerCounter: 0.105 секунд. Значение счетчика: 10
     * ReentrantLockCounter: 1.105 секунд. Значение счетчика: 10
     * SynchronizedBlockCounter: 1.075 секунд. Значение счетчика: 10
     * UnsynchronizedCounter: 0.104 секунд. Значение счетчика: 8
     * VolatileCounter: 0.112 секунд. Значение счетчика: 10
     */

    /**
     * 100 потоков
     * AtomicIntegerCounter: 0.158 секунд. Значение счетчика: 100
     * ReentrantLockCounter: 10.9 секунд. Значение счетчика: 100
     * SynchronizedBlockCounter: 10.874 секунд. Значение счетчика: 100
     * UnsynchronizedCounter: 0.126 секунд. Значение счетчика: 100
     * VolatileCounter: 0.125 секунд. Значение счетчика: 100
     */

    public static void main(String[] args) {
        SiteVisitCounter ac = new AtomicIntegerCounter();
        SiteVisitCounter rlc = new ReentrantLockCounter();
        SiteVisitCounter sbc = new SynchronizedBlockCounter();
        SiteVisitCounter uc = new UnsynchronizedCounter();
        SiteVisitCounter vc = new VolatileCounter();

        List<SiteVisitCounter> visitCounters = new ArrayList<>();
        visitCounters.add(ac);
        visitCounters.add(rlc);
        visitCounters.add(sbc);
        visitCounters.add(uc);
        visitCounters.add(vc);

        for (SiteVisitCounter svc : visitCounters){
            MultithreadingSiteVisitor msv = new MultithreadingSiteVisitor(svc);
            msv.visitMultithread(100);
            msv.waitUntilAllVisited();
            System.out.println(svc.getClass().getSimpleName() + ": " +  msv.getTotalTimeOfHandling() + " секунд. Значение счетчика: " + svc.getVisitCount());
        }
    }
}

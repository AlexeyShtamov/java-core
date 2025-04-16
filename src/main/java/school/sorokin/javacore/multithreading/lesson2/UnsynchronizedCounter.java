package school.sorokin.javacore.multithreading.lesson2;

public class UnsynchronizedCounter implements SiteVisitCounter{

    private int visitCount;


    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        visitCount++;
    }

    @Override
    public int getVisitCount() {
        return visitCount;
    }
}

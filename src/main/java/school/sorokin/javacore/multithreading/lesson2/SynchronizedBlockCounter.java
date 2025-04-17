package school.sorokin.javacore.multithreading.lesson2;

public class SynchronizedBlockCounter implements SiteVisitCounter{

    private Integer visitCount = 0;


    @Override
    public void incrementVisitCount() {
        synchronized (visitCount){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
            visitCount++;
        }
    }

    @Override
    public int getVisitCount() {
        return visitCount;
    }
}

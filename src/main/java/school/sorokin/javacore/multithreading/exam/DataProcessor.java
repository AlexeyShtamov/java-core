package school.sorokin.javacore.multithreading.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {

    private AtomicInteger countOfTasks = new AtomicInteger(0);
    private AtomicInteger activeTasks = new AtomicInteger(0);
    private final Map<String, Integer> results = new HashMap<>();


    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void calculateSumTask(List<Integer> nums){
        String taskName = "task" + countOfTasks.incrementAndGet();


        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() ->
        {
            try {

                return new CalculateSumTask(taskName, nums).call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, executorService);
        activeTasks.getAndIncrement();

        cf.thenAccept(num -> {
            synchronized (results){
                results.put(taskName, num);
            }
            activeTasks.decrementAndGet();
        });


    }

    public int getCountOfTask(){
        return activeTasks.get();
    }

    public Optional<Integer> getResultByTaskName(String taskName){
        synchronized (results){
            return Optional.ofNullable(results.get(taskName));
        }
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            boolean isTerminated = executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
            if (!isTerminated) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
    }

}

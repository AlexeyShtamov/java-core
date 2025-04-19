package school.sorokin.javacore.multithreading.exam;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculateSumTask implements Callable<Integer> {

    private String taskName;
    private List<Integer> nums;

    public CalculateSumTask(String taskName, List<Integer> nums) {
        this.taskName = taskName;
        this.nums = nums;
    }

    @Override
    public Integer call() throws Exception {
        System.out.printf("Имя задачи: %s. Имя потока: %s.\n", taskName, Thread.currentThread().getName());
        Thread.sleep(100);
        return nums.stream().reduce(0, Integer::sum);
    }
}

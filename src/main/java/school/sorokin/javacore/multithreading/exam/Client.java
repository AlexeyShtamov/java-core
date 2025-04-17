package school.sorokin.javacore.multithreading.exam;

import java.util.List;

public class Client {

    public static void main(String[] args) throws InterruptedException {
       DataProcessor dataProcessor = new DataProcessor();

        for (int i = 0; i < 100; i++) {
            List<Integer> someNums = List.of(1 + i, 2 * i, 3 - i, 4 * i, 5 + i, 6 + i, 7 + i);
            dataProcessor.calculateSumTask(someNums);
        }

        while (dataProcessor.getCountOfTask() != 0){
            Thread.sleep(100);
            System.out.println("Количество исполняемых задач: " + dataProcessor.getCountOfTask());
        }

        dataProcessor.shutdown();

        for (int i = 1; i <= 100; i++) {
            String name = "task" + i;
            int result = dataProcessor.getResultByTaskName(name).get();

            System.out.printf("Задача: %s. Результат: %s\n", name, result);
        }

    }
}

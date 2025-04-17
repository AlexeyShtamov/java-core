package school.sorokin.javacore.multithreading.lesson4;

import java.util.concurrent.*;

public class Task {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                System.out.println("Thread started");
                try {
                    Thread.sleep((int)(Math.random() * 3000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 2; i <= 4; i++) {
            int finalI = i;
            Future<String> future = executorService.submit(() -> {
                Thread.sleep((int)(Math.random() * 3000));
                return "Задача " + finalI + " завершилась";
            });
            System.out.println(future.get());
        }

        int finalI = 5;
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(8000);
            return "Задача " + finalI + " завершилась";
        });
        try {
            System.out.println(future.get(3, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("Ошибка");
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
